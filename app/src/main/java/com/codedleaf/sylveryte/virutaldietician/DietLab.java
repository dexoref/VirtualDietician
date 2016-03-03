package com.codedleaf.sylveryte.virutaldietician;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codedleaf.sylveryte.virutaldietician.DietTableSchema.DietTable;
import com.codedleaf.sylveryte.virutaldietician.UserTableSchema.UserTable;

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
        mDatabase=new DietBaseHelper(mContext).getWritableDatabase();
        getDiets();
    }

    public void initiateDB()
    {
        if(mDiets.size()==0)
        {
            BaseDatabaseFile.generateIntialDB();

        }
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public List getDiets() {

        mDiets=new ArrayList<>();
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

        return mDiets;
    }

    public void add(Diet diet) {
        mDiets.add(diet);
        mDatabase.insert(DietTable.NAME, null, getContentValues(diet));
    }

    private static ContentValues getContentValues(Diet diet)
    {
        ContentValues values=new
                ContentValues();
        values.put(DietTable.cols.UUID,diet.getId().toString());
        values.put(DietTable.cols.TITLE,diet.getDietName());
        values.put(DietTable.cols.CALORIES,diet.getCalories());
        values.put(DietTable.cols.DLB, diet.getDlb());
        values.put(DietTable.cols.VEN, diet.getVen());
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

    public void deleteDiet(Diet diet)
    {
        mDiets.remove(diet);
        mDatabase.delete(DietTable.NAME,DietTable.cols.TITLE + " =?",
                new String[]{diet.getDietName()});

    }


    public void writeDownUserDB()
    {
        ///USer writing
        mDatabase.execSQL("delete from " + UserTable.NAME);
        mDatabase.execSQL("vacuum");

        ContentValues userValues=new ContentValues();
        User user=User.getInstance();
        userValues.put(UserTable.cols.NAME,user.getUserName());
        userValues.put(UserTable.cols.AGE,user.getAge());
        userValues.put(UserTable.cols.HEIGHT,user.getHeight());
        userValues.put(UserTable.cols.WEIGHT,user.getWeight());
        userValues.put(UserTable.cols.GENDER,user.isMale()?0:1);
        userValues.put(UserTable.cols.WANTTO, user.getWantTo());
        mDatabase.insert(UserTable.NAME, null, userValues);
    }


    public void readDB()
    {
        Cursor cursorUser=mDatabase.query(
                UserTable.NAME,
                null, // Columns - null selects all columns
                null,
                null,
                null, // groupBy
                null, // having
                null // orderBy
        );
        try {
            cursorUser.moveToFirst();
            if(!cursorUser.isAfterLast()) {

                User user = User.getInstance();
                user.setUserName(cursorUser.getString(
                        cursorUser.getColumnIndex(UserTable.cols.NAME)));
                user.setHeight(cursorUser.getDouble(
                        cursorUser.getColumnIndex(UserTable.cols.HEIGHT)));
                user.setWeight(cursorUser.getDouble(
                        cursorUser.getColumnIndex(UserTable.cols.WEIGHT)));
                user.setAge(cursorUser.getInt(
                        cursorUser.getColumnIndex(UserTable.cols.AGE)));
                int i = cursorUser.getInt(
                        cursorUser.getColumnIndex(UserTable.cols.GENDER));
                if (i == 0) {
                    user.setIsMale(true);
                } else {
                    user.setIsMale(false);
                }

                user.setWantTo(cursorUser.getShort(
                        cursorUser.getColumnIndex(UserTable.cols.WANTTO)));
            }
        }finally {
            cursorUser.close();
        }

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
}
