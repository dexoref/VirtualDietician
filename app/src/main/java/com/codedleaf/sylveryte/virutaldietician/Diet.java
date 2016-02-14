package com.codedleaf.sylveryte.virutaldietician;

import java.util.UUID;

/**
 * Created by sylveryte on 14/2/16.
 */
public class Diet {
    private String mDietName;
    private long mCalories;
    private long mProtien;
    private long mCarbs;
    private long mFat;
    private UUID id;

    public Diet(String dietName,long calories)
    {
        mDietName=dietName;
        mCalories=calories;
        id=UUID.randomUUID();
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

    public long getCalories() {
        return mCalories;
    }

    public void setCalories(long calories) {
        mCalories = calories;
    }
}
