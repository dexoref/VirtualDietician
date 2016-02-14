package com.codedleaf.sylveryte.virutaldietician;

import java.util.UUID;

/**
 * Created by sylveryte on 14/2/16.
 */
public class DietPlan {

    private DietLab mLab=DietLab.get();
    private UUID b1;
    private UUID b2;
    private UUID b3;
    private UUID b4;
    private UUID l1;
    private UUID l2;
    private UUID l3;
    private UUID l4;
    private UUID d1;
    private UUID d2;
    private UUID d3;
    private UUID d4;

    public static DietPlan getInstance() {
        return new DietPlan();
    }

    private DietPlan()
    {
        generatePlan();
    }


    private void generatePlan()
    {
        generateBreakfast();
        generateLunch();
        generateDinner();
    }

    private void generateDinner() {
        mLab.getBreakfast();
    }

    private void generateLunch() {

    }

    private void generateBreakfast() {

    }

}
