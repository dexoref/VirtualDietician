package com.codedleaf.sylveryte.virutaldietician;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sylveryte on 14/2/16.
 */
public class DietPlan {

    private static DietPlan sDietPlan;
    private final SQLiteDatabase mDatabase;
    private DietLab mLab=DietLab.get();
    private List<Diet> mBreakfast;
    private List<Diet> mlunch;
    private List<Diet> mDinner;
    private List<Diet> mDiets;
    private List<Diet> mPlan;
    private List<Diet> bucket;
    private int mTotalCal;
    private int mOne3;

    public static DietPlan getInstance() {
        if(sDietPlan==null)
            sDietPlan=new DietPlan();
        return sDietPlan;
    }

    private DietPlan()
    {
        mDiets=mLab.getDiets();
        mBreakfast=new ArrayList<>();
        mlunch=new ArrayList<>();
        bucket=new ArrayList<>();
        mDinner=new ArrayList<>();
        mDatabase=DietLab.get().getDatabase();
        readDietPlan();
    }

    private DietCursorWrapper queryDiets(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DietPlanTableSchema.DietTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new DietCursorWrapper(cursor);
    }

    private void readDietPlan() {

        //

        DietCursorWrapper cursor=queryDiets(null, null);

        mPlan=new ArrayList<>();

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                mPlan.add(cursor.getDiet());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        if(mPlan.size()==0)
        {
            generatePlan();
        }else
        {
            justInitialExisting();
        }

    }


    private static ContentValues getContentValues(Diet diet)
    {
        ContentValues values=new
                ContentValues();
        values.put(DietTableSchema.DietTable.cols.UUID,diet.getId().toString());
        values.put(DietTableSchema.DietTable.cols.TITLE,diet.getDietName());
        values.put(DietTableSchema.DietTable.cols.CALORIES,diet.getCalories());
        values.put(DietTableSchema.DietTable.cols.DLB, diet.getDlb());
        values.put(DietTableSchema.DietTable.cols.VEN, diet.getVen());
        values.put(DietTableSchema.DietTable.cols.USED, diet.isUsed() ? 1 : 0);
        return values;
    }

    private void writeDownPlanDB() {

        //to be

        mDatabase.execSQL("delete from " + DietPlanTableSchema.DietTable.NAME);
        mDatabase.execSQL("vacuum");

        for (Diet diet:mPlan)
        {
            mDatabase.insert(DietPlanTableSchema.DietTable.NAME, null,getContentValues(diet));
        }

    }




    public List<Diet> getDinner() {
        return mDinner;
    }


    public List<Diet> getMlunch() {
        return mlunch;
    }


    public List<Diet> getBreakfast() {
        return mBreakfast;
    }



    public void justInitialExisting()
    {
        mOne3 = ((int) User.getInstance().getBMR()) / 3;
        mTotalCal=0;

        setList(Diet.BREAKFAST,mPlan);
        finalList(mBreakfast);
        setList(Diet.LUNCH, mPlan);
        finalList(mlunch);
        setList(Diet.DINNER, mPlan);
        finalList(mDinner);
    }

    public void generatePlan() {
        mOne3 = ((int) User.getInstance().getBMR()) / 3;
        mTotalCal=0;

        mPlan.clear();
        setList(Diet.BREAKFAST, mDiets);
        finalList(mBreakfast);
        setList(Diet.LUNCH, mDiets);
        finalList(mlunch);
        setList(Diet.DINNER, mDiets);
        finalList(mDinner);

        for (Diet d: mBreakfast)
        {
            mPlan.add(d);
        }
        for (Diet d: mlunch)
        {
            mPlan.add(d);
        }
        for (Diet d: mDinner)
        {
            mPlan.add(d);
        }

        for (Diet d:mPlan)
        {
            ShoppingLab.get().addShoppingItem(new ShoppingItem(d.getDietName(),1, String.format("have %s calories", d.getCalories())));
        }

        writeDownPlanDB();
    }




    private void finalList(List<Diet> cup)
    {
        cup.clear();
        for (int i=0,t=0;i<bucket.size()&&t<=mOne3;i++)
        {
            Diet diet=bucket.get(i);
            t+=diet.getCalories();
            mTotalCal+=diet.getCalories();
            diet.setIsUsed(true);
            cup.add(diet);
        }
        bucket.clear();
    }

    private void setList(int dlb,List<Diet> pl)
    {
        if(pl==mDiets)
        {
            Collections.shuffle(pl);
        }

        for (int i=0;i<pl.size();i++)
        {
            Diet diet=pl.get(i);
            if(diet.getVen()<=User.getInstance().getVEN()) {
                if (diet.getDlb() == dlb) {
                    diet.increaseRank();
                }
                bucket.add(diet);
            }
        }
        Collections.sort(bucket);
    }

}
