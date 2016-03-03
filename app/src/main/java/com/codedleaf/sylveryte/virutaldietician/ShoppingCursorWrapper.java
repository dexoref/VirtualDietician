package com.codedleaf.sylveryte.virutaldietician;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by sylveryte on 3/3/16.
 */
public class ShoppingCursorWrapper extends CursorWrapper {
    public ShoppingCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public ShoppingItem getShoppingItem()
    {
            String name=getString(getColumnIndex(ShoppingSchema.Cols.ITEMNAME));
            String extra=getString(getColumnIndex(ShoppingSchema.Cols.ITEMNAME));
            int qnt=getInt(getColumnIndex(ShoppingSchema.Cols.ITEMNAME));
            int i=getInt(getColumnIndex(ShoppingSchema.Cols.PURCHASED));
        boolean perl=false;
        if(i==1)
        {
            perl=true;
        }

        return new ShoppingItem(name,qnt,extra,perl);
    }
}
