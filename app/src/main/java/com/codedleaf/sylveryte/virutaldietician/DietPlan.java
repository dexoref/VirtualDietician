package com.codedleaf.sylveryte.virutaldietician;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sylveryte on 14/2/16.
 */
public class DietPlan {

    private DietLab mLab=DietLab.get();
    private List<Diet> mBreakfast;
    private List<Diet> mlunch;
    private List<Diet> mDinner;
    private List<Diet> mDiets;
    private List<Diet> bucket;
    private int mTotalCal;
    private int mOne3;

    public static DietPlan getInstance() {
        return new DietPlan();
    }

    private DietPlan()
    {
        mDiets=mLab.getDiets();
        mBreakfast=new ArrayList<>();
        mlunch=new ArrayList<>();
        bucket=new ArrayList<>();
        mDinner=new ArrayList<>();
        mTotalCal=0;

        generatePlan();
    }

    public List<Diet> getDinner() {
        return mDinner;
    }

    public List<Diet> getMlunch() {
        return mlunch;
    }
    public List<Diet> getBreakfast() {
        return mBreakfast;
    }
    public void generatePlan() {
        mOne3 = ((int) User.getInstance().getBMR()) / 3;

        setList(Diet.BREAKFAST);
        finalList(mBreakfast);
        setList(Diet.LUNCH);
        finalList(mlunch);
        setList(Diet.DINNER);
        finalList(mDinner);
    }
    private void finalList(List<Diet> cup)
    {
        for (int i=0,t=0;i<bucket.size()&&t<=mOne3;i++)
        {
            Diet diet=bucket.get(i);
            t+=diet.getCalories();
            mTotalCal+=diet.getCalories();
            diet.setIsUsed(true);
            cup.add(diet);
        }
        bucket.clear();
    }

    private void setList(int dlb)
    {
        Collections.shuffle(mDiets);
        for (int i=0;i<mDiets.size();i++)
        {
            Diet diet=mDiets.get(i);
                if (diet.getDlb()==dlb)
                {
                    diet.increaseRank();
                }
                bucket.add(diet);
        }
        Collections.sort(bucket);
    }

}
