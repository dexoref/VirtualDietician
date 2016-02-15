package com.codedleaf.sylveryte.virutaldietician;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.codedleaf.sylveryte.virutaldietician.DietTableSchema.DietTable;

import java.util.UUID;

/**
 * Created by sylveryte on 15/2/16.
 */
public class DietCursorWrapper extends CursorWrapper{
    public DietCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Diet getDiet()
    {
        String uuidString=getString(getColumnIndex(DietTable.cols.UUID));
        String title=getString(getColumnIndex(DietTable.cols.TITLE));
        double calories=getDouble(getColumnIndex(DietTable.cols.CALORIES));
        int dlb=getInt(getColumnIndex(DietTable.cols.DLB));
        int ven=getInt(getColumnIndex(DietTable.cols.VEN));
        int used=getInt(getColumnIndex(DietTable.cols.USED));

        Diet diet=new Diet(
                UUID.fromString(uuidString),
                title,
                calories,
                dlb,
                ven
        );
        diet.setIsUsed(used==1);
        return diet;
    }

}
