package com.codedleaf.sylveryte.virutaldietician;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sylveryte on 3/3/16.
 */
public class ShoppingLab {

    private static ShoppingLab sShoppingLab;
    private List<ShoppingItem> mItems;
    private SQLiteDatabase mDatabase;
    public static ShoppingLab get()
    {
        if(sShoppingLab ==null)
        {
            sShoppingLab =new ShoppingLab();
        }
        return sShoppingLab;

        //cleanup
    }

    private ShoppingLab()
    {
        mDatabase=DietLab.get().getDatabase();
    }

    private ShoppingCursorWrapper queryShop(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ShoppingSchema.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new ShoppingCursorWrapper(cursor);
    }

    public List<ShoppingItem> getItems()
    {
        ShoppingCursorWrapper cursor=queryShop(null, null);

        mItems=new ArrayList<>();

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                mItems.add(cursor.getShoppingItem());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }

        return mItems;
    }

    private static ContentValues getContentValues(ShoppingItem item)
    {
        ContentValues values=new
                ContentValues();
        values.put(ShoppingSchema.Cols.ITEMNAME,item.getItemName());
        values.put(ShoppingSchema.Cols.EXTRA,item.getExtraInfo());
        values.put(ShoppingSchema.Cols.QUANTITY, item.getQuantity());
        values.put(ShoppingSchema.Cols.PURCHASED, item.isPurcahsed() ? 1 : 0);
        return values;
    }

    public void clearShoppinglist() {
        getItems();
        mItems.clear();
        mDatabase.execSQL("delete from " + ShoppingSchema.NAME);
        mDatabase.execSQL("vacuum");
    }

    public void addShoppingItem(ShoppingItem item)
    {
        getItems();
        mItems.add(item);
        mDatabase.insert(ShoppingSchema.NAME, null, getContentValues(item));
    }

    public void updateShoppingItem(ShoppingItem item)
    {
        mDatabase.update(ShoppingSchema.NAME,getContentValues(item),ShoppingSchema.Cols.ITEMNAME + " =?",
                new String[]{item.getItemName()});
    }

    public void deleteShoppingItem(ShoppingItem item)
    {
        mItems.remove(item);
        mDatabase.delete(ShoppingSchema.NAME, ShoppingSchema.Cols.ITEMNAME + " =?",
                new String[]{item.getItemName()});
    }

}
