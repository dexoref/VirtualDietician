package com.codedleaf.sylveryte.virutaldietician;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codedleaf.sylveryte.virutaldietician.DietTableSchema.DietTable;


/**
 * Created by sylveryte on 15/2/16.
 */
public class DietBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="dietBase.db";

    public DietBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DietTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        DietTable.cols.UUID + ", " +
                        DietTable.cols.TITLE + ", " +
                        DietTable.cols.CALORIES + ", " +
                        DietTable.cols.DLB + ", " +
                        DietTable.cols.VEN + ", " +
                        DietTable.cols.USED +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
