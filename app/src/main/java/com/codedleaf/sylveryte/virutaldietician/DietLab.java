package com.codedleaf.sylveryte.virutaldietician;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codedleaf.sylveryte.virutaldietician.DietTableSchema.DietTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




/**
 * Created by sylveryte on 14/2/16.
 */
public class DietLab {
    private static DietLab sDietLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private List<Diet> mDiets;


    public static DietLab get()
    {
        return sDietLab;
    }

    public static void createAbsoluteOneCrimeLab(Context context)
    {
        sDietLab=new DietLab(context);
    }

    private DietLab(Context context)
    {
        mContext=context.getApplicationContext();
        mDiets=new ArrayList();
    }

    public void initiateDB()
    {
        BaseDatabaseFile.generateIntialDB();
        mDatabase=new DietBaseHelper(mContext).getWritableDatabase();
    }

    public List getDiets() {
        return mDiets;
    }

    public void addDiet(Diet diet) {
        mDiets.add(diet);
    }

    private static ContentValues getContentValues(Diet diet)
    {
        ContentValues values=new
                ContentValues();
        values.put(DietTable.cols.UUID,diet.getId().toString());
        values.put(DietTable.cols.TITLE,diet.getDietName());
        values.put(DietTable.cols.CALORIES, String.format("%s", diet.getCalories()));
        values.put(DietTable.cols.DLB, String.format("%d", diet.getDlb()));
        values.put(DietTable.cols.VEN, String.format("%d", diet.getVen()));
        values.put(DietTable.cols.USED, diet.isUsed() ? 1 : 0);
        return values;
    }
    private DietCursorWrapper queryDiets(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DietTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new DietCursorWrapper(cursor);
    }

    public void writeDownDiets()
    {

        for(Diet diet:mDiets)
        {
            mDatabase.insert(DietTable.NAME,null,getContentValues(diet));
        }

    }


    public void readDiets()
    {
        DietCursorWrapper cursor=queryDiets(null,null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                mDiets.add(cursor.getDiet());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }

        //clear db
        mDatabase.execSQL("delete from "+DietTable.NAME);
        mDatabase.execSQL("vacuum");
    }

    public Diet getDietById(UUID uuid)
    {
        for (Diet diet:mDiets)
        {
            if (diet.getId().equals(uuid))
            {
                return diet;
            }
        }
        return null;
    }

    public void getBreakfast()
    {

    }



}
