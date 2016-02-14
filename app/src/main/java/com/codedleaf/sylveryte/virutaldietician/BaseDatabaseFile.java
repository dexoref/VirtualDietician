package com.codedleaf.sylveryte.virutaldietician;

import java.util.List;

/**
 * Created by sylveryte on 15/2/16.
 */
public class BaseDatabaseFile {
    private List<Diet> mDiets;
    private static BaseDatabaseFile sBaseDatabaseFile;

    private BaseDatabaseFile()
    {
        mDiets=DietLab.get().getDiets();
        generateList();
    }

    public static BaseDatabaseFile getInstance() {
        return sBaseDatabaseFile;
    }

    void generateList()
    {
        mDiets.add(new Diet("Egg boiled",230,41,52));
        mDiets.add(new Diet("Egg Fried",110,41,52));
        mDiets.add(new Diet("Bread slice",45,44,51));
        mDiets.add(new Diet("Bread slice with butter",90,44,51));
        mDiets.add(new Diet("chapati (3)",180,45,51));
        mDiets.add(new Diet("subji (1 cup)",150,45,51));
        mDiets.add(new Diet("paratha",150,45,51));
        mDiets.add(new Diet("idli",110,44,51));
        mDiets.add(new Diet("Cooked Rice/plain (1cup)",120,45,51));
        mDiets.add(new Diet("Dal (1 cup)",150,45,51));
        mDiets.add(new Diet("fruit (1helping)",150,44,51));
    }

}
