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

        //temporary till db
        mDiets.add(new Diet("vadapav",24));
        mDiets.add(new Diet("chilli IceCream",64));
        mDiets.add(new Diet("ragda fries",74));
        mDiets.add(new Diet("boiled chips",344));
        mDiets.add(new Diet("chiken achhar",54));
        mDiets.add(new Diet("baingan roti",14));
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


}
