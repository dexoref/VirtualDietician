package com.codedleaf.sylveryte.virutaldietician;

/**
 * Created by sylveryte on 3/3/16.
 */
public class ShoppingItem {

    private String mItemName;
    private int mQuantity;
    private String mExtraInfo;
    private boolean mIsPurcahsed;

    public ShoppingItem(String name,int quantity,String extraInfo, boolean isPurcahsed)
    {
        this(name,quantity,extraInfo);
        mIsPurcahsed=isPurcahsed;
    }

    public ShoppingItem(String name,int quantity,String extraInfo)
    {
        mItemName=name;
        mQuantity=quantity;
        mExtraInfo=extraInfo;
        mIsPurcahsed=false;
    }

    public void setIsPurcahsed(boolean isPurcahsed) {
        mIsPurcahsed = isPurcahsed;
    }

    public String getItemName() {
        return mItemName;
    }

    public boolean isPurcahsed() {
        return mIsPurcahsed;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public String getExtraInfo() {
        return mExtraInfo;
    }
}
