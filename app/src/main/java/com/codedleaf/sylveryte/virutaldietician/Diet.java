package com.codedleaf.sylveryte.virutaldietician;

import java.util.UUID;

/**
 * Created by sylveryte on 14/2/16.
 */
public class Diet implements Comparable{
    private String mDietName;
    private double mCalories;
    private int mDlb;
    private int mVen;
    private boolean isUsed;
    private UUID id;
    private int mRank;

    public static final int BREAKFAST=41;
    public static final int LUNCH=42;
    public static final int DINNER=43;
    public static final int BREAKFASTLUNCH=44;
    public static final int ANYTIME=45;
    public static final int VEGETARIAN=51;
    public static final int EGGETARIAN=52;
    public static final int NONVEGETARIAN=53;

    @Override
    public int compareTo(Object another) {
        int comparank=((Diet)another).getRank();
        return comparank-this.getRank();
    }

    public Diet(UUID newId,String dietName,double calories,int dlb,int ven)
    {

        mDietName=dietName;
        mCalories=calories;
        mDlb=dlb;
        mVen=ven;
        id=newId;
        isUsed=false;
        mRank=0;
    }

    public Diet(String dietName,double calories,int dlb,int ven)
    {
        this(UUID.randomUUID(),dietName,calories,dlb,ven);
    }

    public int getRank() {
        return mRank;
    }

    public void increaseRank()
    {
        mRank++;
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

    public String getStringVen() {
        String s;
        switch (mVen) {
            case VEGETARIAN:
                s= "Vegetarian";
            break;
            case EGGETARIAN:
                s= "Eggetarian";
            break;
            case NONVEGETARIAN:
                s= "Non-Vegetarian";
            break;
            default: s="Not Specified";
        }
        return s;
    }


    public int getDlb() {
        return mDlb;
    }

    public String getStringDlb() {
        String s;
        switch (mDlb)
        {
            case BREAKFAST: s="Breakfast"; break;
            case LUNCH: s="Lunch"; break;
            case DINNER: s="Dinner"; break;
            case ANYTIME: s="Anytime"; break;
            default: s="Anytime"; break;
        }
        return s;
    }

    public void setCalories(long calories) {
        mCalories = calories;
    }
}
