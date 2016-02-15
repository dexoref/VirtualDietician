package com.codedleaf.sylveryte.virutaldietician;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codedleaf.sylveryte.virutaldietician.DietPlanSchema.DietPlanTable;
import com.codedleaf.sylveryte.virutaldietician.UserTableSchema.UserTable;

/**
 * Created by sylveryte on 15/2/16.
 */
public class DietPlanBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="dietPlanBase.db";

    public DietPlanBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DietPlanTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        DietPlanTable.cols.BREAKFAST + ", " +
                        DietPlanTable.cols.LUNCH + ", " +
                        DietPlanTable.cols.DINNER +
                        ")"
        );
        db.execSQL("create table " + UserTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        UserTable.cols.NAME + ", " +
                        UserTable.cols.HEIGHT + ", " +
                        UserTable.cols.WEIGHT + ", " +
                        UserTable.cols.AGE + ", " +
                        UserTable.cols.GENDER + ", " +
                        UserTable.cols.WANTTO +
                        ")"
        );
        db.execSQL("create table " + DietPlanTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        UserTable.cols.NAME + ", " +
                        UserTable.cols.HEIGHT + ", " +
                        UserTable.cols.WEIGHT + ", " +
                        UserTable.cols.AGE + ", " +
                        UserTable.cols.GENDER + ", " +
                        UserTable.cols.WANTTO +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}