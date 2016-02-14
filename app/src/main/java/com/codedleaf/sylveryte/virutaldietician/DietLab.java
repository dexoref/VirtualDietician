package com.codedleaf.sylveryte.virutaldietician;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




/**
 * Created by sylveryte on 14/2/16.
 */
public class DietLab {
    private static DietLab sDietLab;
    private List<Diet> mDiets;


    public static DietLab get()
    {
        if(sDietLab==null)
        {
            sDietLab=new DietLab();
        }
        return sDietLab;
    }

    private DietLab()
    {
        mDiets=new ArrayList();
    }

    public List getDiets() {
        return mDiets;
    }

    public void addDiet(Diet diet) {
        mDiets.add(diet);
    }


    public Diet getDietById(UUID uuid)
    {
        for (Diet diet:mDiets)
        {
            if (diet.getId().equals(uuid))
            {
                return diet;
            }
        }
        return null;
    }

    public void getBreakfast()
    {

    }



}
