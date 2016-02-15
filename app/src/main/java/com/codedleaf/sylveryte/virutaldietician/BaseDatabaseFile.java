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

    public static void generateIntialDB() {
        if(sBaseDatabaseFile==null)
        {
            sBaseDatabaseFile=new BaseDatabaseFile();
        }
    }

    private void generateList()
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
        mDiets.add(new Diet("tea 1 cup(2tsp cream & 2tsp sugar)",70,45,51));
        mDiets.add(new Diet("coffee 1 cup(2tsp cream & 2tsp sugar)",70,45,51));
        mDiets.add(new Diet("beer regular(350ml)",150,45,51));
        mDiets.add(new Diet("beer,light(350ml)",100,45,51));
        mDiets.add(new Diet("gin,rum/whisky/vodka)",145,45,51));
        mDiets.add(new Diet("(86 proof) 1 jigger(43ml) gin,rum/whisky/vodka(80 proof)",93,45,51));
        mDiets.add(new Diet("wines (sweet)1 glass(100ml)",140,45,51));
        mDiets.add(new Diet("champagne(100ml)",84,45,51));
        mDiets.add(new Diet("tomato juice(100ml)",40,45,51));
        mDiets.add(new Diet("orange juice(100ml)",61,45,51));
        mDiets.add(new Diet("coconut water(100ml)",24,43,51));
        mDiets.add(new Diet("coconut water(100ml)",24,43,51));
        mDiets.add(new Diet("apple juice(100ml)",59,43,51));
        mDiets.add(new Diet("fresh lime(without sugar) 1 glass(150ml)",145,43,51));
        mDiets.add(new Diet("fresh lime(with 2tsp sugar) 1 glass(150ml)",55,43,51));
        mDiets.add(new Diet("kachori(1 small)",200,45,51));
        mDiets.add(new Diet("samosa(1 big/65gm)",210,43,51));
        mDiets.add(new Diet("vada(dhai)(2 pieces)",345,43,51));
        mDiets.add(new Diet("bhelpuri(1 plate small)",130,42,51));
        mDiets.add(new Diet("chat(plate with 5 papries)",210,45,51));
        mDiets.add(new Diet("namkeen(fried)(2 tsp)",85,45,51));
        mDiets.add(new Diet("sandwich(2)(65gm) with butter",195,43,51));
        mDiets.add(new Diet("pan cake(1 plain)",160,45,51));
        mDiets.add(new Diet("hamburger(1 big boy)",570,42,51));
        mDiets.add(new Diet("chicken nuggets(6)",323,41,53));
        mDiets.add(new Diet("icecream(100 gms)1 small cup",200,41,51));
        mDiets.add(new Diet("kulfi(100gms) 1 small cup",300,41,51));
        mDiets.add(new Diet("soyabean milk(225ml)",87,42,51));
        mDiets.add(new Diet("rice(boiled/steamed) (100 gm/1 katori)",110,41,51));
        mDiets.add(new Diet("rice pulao ( 150 gm/1 katori)",180,41,51));
        mDiets.add(new Diet("kichri(100 gm/1 katori)",215,43,51));
        mDiets.add(new Diet("idli(sooji/rice) (115 gm/two)",155,42,51));
        mDiets.add(new Diet("upma(130 gm/1 katoro)",210,42,51));
        mDiets.add(new Diet("noodles(boiled) (1 cup)",200,43,51));
        mDiets.add(new Diet("bread brown( 1 slice/25 gm)",65,42,51));
        mDiets.add(new Diet("bread white( 1 slice/25 gm)",70,42,51));
        mDiets.add(new Diet("sambhar(160 gm/1 katori)",80,42,51));
        mDiets.add(new Diet("potato( fresh) (100gms )",97,43,51));
        mDiets.add(new Diet("onion( half cup sliced)",23,41,51));
        mDiets.add(new Diet("peas(half cup fresh boiled)",55,45,51));
        mDiets.add(new Diet("carrot( half cup)",25,43,51));
        mDiets.add(new Diet("cabbaga( shredded 1 cup)",12,45,51));
        mDiets.add(new Diet("cucumber 6 slice)",5,45,51));
        mDiets.add(new Diet("pumpkin(half cup cooked)",33,45,51));
        mDiets.add(new Diet("brinjal( 100 gm coocked)",70,41,51));
        mDiets.add(new Diet("mushroom( half cup)",10,45,51));
    }
}
