package com.codedleaf.sylveryte.virutaldietician;

import java.util.UUID;

/**
 * Created by sylveryte on 14/2/16.
 */
public class Diet {
    private String mDietName;
    private double mCalories;
    private int mDlb;
    private int mVen;
    private boolean isUsed;
    private UUID id;

    public Diet(UUID newId,String dietName,double calories,int dlb,int ven)
    {

        mDietName=dietName;
        mCalories=calories;
        mDlb=dlb;
        mVen=ven;
        id=newId;
        isUsed=false;
    }

    public Diet(String dietName,double calories,int dlb,int ven)
    {
        this(UUID.randomUUID(),dietName,calories,dlb,ven);
    }

    public UUID getId() {
        return id;
    }

    public String getDietName() {
        return mDietName;
    }

    public void setDietName(String dietName) {
        mDietName = dietName;
    }

    public double getCalories() {
        return mCalories;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public int getVen() {
        return mVen;
    }

    public int getDlb() {
        return mDlb;
    }

    public void setCalories(long calories) {
        mCalories = calories;
    }
}
