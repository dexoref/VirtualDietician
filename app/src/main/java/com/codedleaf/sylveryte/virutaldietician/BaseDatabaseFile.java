package com.codedleaf.sylveryte.virutaldietician;

import java.util.List;

/**
 * Created by sylveryte on 15/2/16.
 */
public class BaseDatabaseFile {
    private DietLab mDiets;
    private static BaseDatabaseFile sBaseDatabaseFile;

    private BaseDatabaseFile()
    {
        mDiets= DietLab.get();
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
        mDiets.add(new Diet("beer regular(350ml)",150,45,51));
        mDiets.add(new Diet("beer,light(350ml)",100,45,51));
        mDiets.add(new Diet("wines (sweet)1 glass(100ml)",140,45,51));
        mDiets.add(new Diet("champagne(100ml)",84,45,51));
        mDiets.add(new Diet("tomato juice(100ml)",40,45,51));
        mDiets.add(new Diet("orange juice(100ml)",61,45,51));
        mDiets.add(new Diet("coconut water(100ml)",24,43,51));
        mDiets.add(new Diet("Chicken meat(42 g)",116,42,53));
        mDiets.add(new Diet("coconut water(100ml)",24,42,51));
        mDiets.add(new Diet("fresh lime(without sugar) 1 glass(150ml)",145,43,51));
        mDiets.add(new Diet("fresh lime(with 2tsp sugar) 1 glass(150ml)",55,42,51));
        mDiets.add(new Diet("kachori(1 small)",200,45,51));
        mDiets.add(new Diet("samosa(1 big/65gm)",210,43,51));
        mDiets.add(new Diet("vada(dhai)(2 pieces)",345,43,51));
        mDiets.add(new Diet("chat(plate with 5 papries)",210,45,51));
        mDiets.add(new Diet("namkeen(fried)(2 tsp)",85,45,51));
        mDiets.add(new Diet("sandwich(2)(65gm) with butter",195,43,51));
        mDiets.add(new Diet("chicken nuggets(6)",323,41,53));
        mDiets.add(new Diet("icecream(100 gms)1 small cup",200,43,51));
        mDiets.add(new Diet("kulfi(100gms) 1 small cup",300,43,51));
        mDiets.add(new Diet("soyabean milk(225ml)",87,42,51));
        mDiets.add(new Diet("rice(boiled/steamed) (100 gm/1 katori)",110,41,51));
        mDiets.add(new Diet("rice pulao ( 150 gm/1 katori)",180,41,51));
        mDiets.add(new Diet("khichdi(100 gm/1 katori)",215,43,51));
        mDiets.add(new Diet("idli(sooji/rice) (115 gm/two)",155,42,51));
        mDiets.add(new Diet("upma(130 gm/1 katoro)",210,42,51));
        mDiets.add(new Diet("noodles(boiled) (1 cup)",200,43,51));
        mDiets.add(new Diet("onion( half cup sliced)",23,41,51));
        mDiets.add(new Diet("peas(half cup fresh boiled)",55,45,51));
        mDiets.add(new Diet("carrot( half cup)",25,43,51));
        mDiets.add(new Diet("cabbaga( shredded 1 cup)",12,45,51));
        mDiets.add(new Diet("cucumber 6 slice)",5,45,51));
        mDiets.add(new Diet("pumpkin(half cup cooked)",33,45,51));
        mDiets.add(new Diet("brinjal( 100 gm coocked)",70,41,51));
        mDiets.add(new Diet("mushroom( half cup)",10,45,51));
        mDiets.add(new Diet("Egg Boiled",80,41,52));
        mDiets.add(new Diet("Egg Poached",80,41,52));
        mDiets.add(new Diet("Egg Fried",110,41,52));
        mDiets.add(new Diet("Omelet with cheese and vegetables(113 g)",252,45,52));
        mDiets.add(new Diet("Duck eggs(One,big)",130,41,52));
        mDiets.add(new Diet("Full cook boiled eggs(One,big)",79,45,52));
        mDiets.add(new Diet("Fresh egg yolk(One,big)",59,45,52));
        mDiets.add(new Diet("Egg Omlet",120,41,52));
        mDiets.add(new Diet("Bread Slice",45,41,51));
        mDiets.add(new Diet("Bread Slice with Butter",90,41,51));
        mDiets.add(new Diet("Chapati",60,41,51));
        mDiets.add(new Diet("Paratha",150,41,51));
        mDiets.add(new Diet("Puri",75,41,51));
        mDiets.add(new Diet("Subji(1 cup)",150,41,51));
        mDiets.add(new Diet("Idli",100,41,51));
        mDiets.add(new Diet("Dosa Plain",120,41,51));
        mDiets.add(new Diet("Dosa Masala",251,41,51));
        mDiets.add(new Diet("Sambhar(1 cup)",150,41,51));
        mDiets.add(new Diet("Corn Flakes(Cup,25 g))",95,41,51));
        mDiets.add(new Diet("French Bread(Quarter of a loaf,115 g)",333,41,51));
        mDiets.add(new Diet("Plain white toast(A Slice))",64,41,51));
        mDiets.add(new Diet("Bread, cereals(100 g))",17,41,51));
        mDiets.add(new Diet("Manaqich (bread with thyme)(One, 75 g))",208,41,51));
        mDiets.add(new Diet("Sammon(One, 75 g))",209,41,51));
        mDiets.add(new Diet("Spaghetti, cooked or pasta(Half a cup))",99,41,51));
        mDiets.add(new Diet("Lasagna with meat sauce(Half a cup))",154,41,53));
        mDiets.add(new Diet("Barley(One cup))",672,41,51));
        mDiets.add(new Diet("Chicken leg(hip),without skin,grilled(85 g))",167,41,53));
        mDiets.add(new Diet("Chicken leg(hip),with skin,grilled(85 g))",223,41,53));
        mDiets.add(new Diet("Chicken breast,without skin,grilled(Half a breast))",142,41,53));
        mDiets.add(new Diet("Chicken breast,with skin,grilled(Half a breast))",193,41,53));
        mDiets.add(new Diet("Chicken breast,without skin,fried(Half a breast))",161,41,53));
        mDiets.add(new Diet("Tuna,canned in water(85 g))",104,41,53));
        mDiets.add(new Diet("Smoked salmon(85 g))",99,41,53));
        mDiets.add(new Diet("Caviar, black or red(1 tablespoon))",40,41,53));
        mDiets.add(new Diet("Oysters,fried with rusk(28 g))",84,41,53));
        mDiets.add(new Diet("Oyster,uncooked(28 g))",23,41,53));
        mDiets.add(new Diet("Shrimp,cooked(85 g))",83,41,53));
        mDiets.add(new Diet("Crab,canned(85 g))",84,41,53));
        mDiets.add(new Diet("Shrimp fried with rusk(85 g))",206,41,53));
        mDiets.add(new Diet("Fish fried with rusk(3 piecies,85 g))",228,41,53));
        mDiets.add(new Diet("Grilled Fish(85 g))",136,41,53));
        mDiets.add(new Diet("Tuna,canned in oil(85 g))",169,41,53));
        mDiets.add(new Diet("Red dark meat,with skin(85 g))",190,41,53));
        mDiets.add(new Diet("Red dark meat,without skin(85 g))",161,41,53));
        mDiets.add(new Diet("Duck meat,without skin,roasted(85 g))",173,41,53));
        mDiets.add(new Diet("Chicken livers,cooked(85 g))",132,41,53));
        mDiets.add(new Diet("Chicken gizzards,fried(85 g))",238,41,53));
        mDiets.add(new Diet("CornStarch(One cup))",471,41,51));
        mDiets.add(new Diet("Plain biscuits(4 pieces,55 g))",178,41,51));
        mDiets.add(new Diet("Spaghetti, cooked with minced meat and tomato(Half a cup))",110,41,53));
        mDiets.add(new Diet("Cooked Rice/Plain(1 cup)",120,42,51));
        mDiets.add(new Diet("Chapati",60,42,51));
        mDiets.add(new Diet("Cooked Rice/Fried(1 cup)",150,42,51));
        mDiets.add(new Diet("Cooked Rice/Fried(1 cup)",150,43,51));
        mDiets.add(new Diet("Sambhar(1 cup)",150,42,51));
        mDiets.add(new Diet("Sambhar(1 cup)",150,43,51));
        mDiets.add(new Diet("Paratha",150,42,51));
        mDiets.add(new Diet("Paratha",150,43,51));
        mDiets.add(new Diet("Dal(1 cup)",150,42,51));
        mDiets.add(new Diet("Curry/Vegetable(1 cup)",150,42,51));
        mDiets.add(new Diet("Curry/Vegetable(1 cup)",150,43,51));
        mDiets.add(new Diet("Curry/Meat(1 cup)",175,42,53));
        mDiets.add(new Diet("Curd",100,42,51));
        mDiets.add(new Diet("Curd",100,43,51));
        mDiets.add(new Diet("Nan",150,43,51));
        mDiets.add(new Diet("Fried eggplant",100,43,51));
        mDiets.add(new Diet("Nan",150,42,51));
        mDiets.add(new Diet("Green beans,cooked",20,43,51));
        mDiets.add(new Diet("Green beans,canned",25,42,51));
        mDiets.add(new Diet("Salad(1 cup)",100,42,51));
        mDiets.add(new Diet("Cutlet",75,42,51));
        mDiets.add(new Diet("Fresh onions,chopped",27,43,51));
        mDiets.add(new Diet("Fresh onions,chopped",27,42,51));
        mDiets.add(new Diet("Baked potato,with the peel(195 g)",220,43,51));
        mDiets.add(new Diet("Baked potato,without the peel(195 g)",162,42,51));
        mDiets.add(new Diet("Fried potato(10 piecies,42 g)",158,43,51));
        mDiets.add(new Diet("Cabbage(One cup)",46,42,51));
        mDiets.add(new Diet("Beet(One cup)",46,43,51));
        mDiets.add(new Diet("Celery",10,43,51));
        mDiets.add(new Diet("Sweet potatoes,mashed",111,42,51));
        mDiets.add(new Diet("Anchovies,canned in oil(21 g)",58,43,53));
        mDiets.add(new Diet("Chicken livers,cooked(85 g)",135,43,53));
        mDiets.add(new Diet("Grilled Fish(85 g)",136,43,53));
        mDiets.add(new Diet("Cauliflower,cooked",51,43,51));
        mDiets.add(new Diet("Squash",41,43,51));
        mDiets.add(new Diet("Mushrooms,fresh",9,43,51));
        mDiets.add(new Diet("Mushroom,canned",19,42,51));
        mDiets.add(new Diet("Green peas,cooked",67,43,51));
        mDiets.add(new Diet("Green beans(One cup)",73,43,51));
        mDiets.add(new Diet("Red tomatoes(One,medium)",26,43,51));
        mDiets.add(new Diet("Chopped spinach(Half a cup)",6,43,51));
        mDiets.add(new Diet("Lettuce",4,43,51));
        mDiets.add(new Diet("Corn(One,medium)",77,43,51));
        mDiets.add(new Diet("Soup/Clear(1 cup)",75,42,51));
        mDiets.add(new Diet("Soup/Heavy(1 cup)",75,42,51));
        mDiets.add(new Diet("Hamburger(1 pc)",250,42,53));
        mDiets.add(new Diet("Steak & Salad(1 plate)",300,42,53));
        mDiets.add(new Diet("Spaghetti & meat,sauce(1 plate)",450,42,53));
        mDiets.add(new Diet("Fried Chicken(1 helping)",200,42,53));
        mDiets.add(new Diet("Beef",142,42,53));
        mDiets.add(new Diet("Pastrami-turkey(28 g)",40,42,53));
        mDiets.add(new Diet("Mortadella-beef(28 g)",47,42,53));
        mDiets.add(new Diet("Frankfurter(28 g)",80,42,53));
        mDiets.add(new Diet("Apple juice(Half a cup)",60,45,51));
        mDiets.add(new Diet("Apricot juice,canned(Half a cup)",72,45,51));
        mDiets.add(new Diet("Fresh orange juice(Half a cup)",59,45,51));
        mDiets.add(new Diet("Kiwi(One, 76 g)",46,45,51));
        mDiets.add(new Diet("Avocado(Half)",162,45,51));
        mDiets.add(new Diet("Pomegranate(Medium,150 g)",110,45,51));
        mDiets.add(new Diet("Fruit salad (with sugar syrup)",107,45,51));
        mDiets.add(new Diet("Sweet Lemon",53,45,51));
        mDiets.add(new Diet("Strawberries",23,45,51));
        mDiets.add(new Diet("Watermelon(Piece,100 g)",26,45,51));
        mDiets.add(new Diet("Nectarine(Medium,142 g)",67,45,51));
        mDiets.add(new Diet("Papaya(Medium)",117,45,51));
        mDiets.add(new Diet("Grapefruit(Half)",38,45,51));
        mDiets.add(new Diet("Apricot(Medium,30 g)",17,45,51));
        mDiets.add(new Diet("Apples(Medium,140 g)",81,45,51));
        mDiets.add(new Diet("Mango juice(One cup)",110,45,51));
        mDiets.add(new Diet("Guava juice(One cup)",175,45,51));
        mDiets.add(new Diet("Grapefruit juice,unsweetened",47,45,51));
        mDiets.add(new Diet("Nescafe coffee without sugar",5,41,51));
        mDiets.add(new Diet("Instant coffee without caffeine",5,41,51));
        mDiets.add(new Diet("Tea without sugar",1,41,51));
        mDiets.add(new Diet("American coffee",5,41,51));
        mDiets.add(new Diet("Puddings(1 cup)",200,43,51));
        mDiets.add(new Diet("Milk-Shake",200,45,51));
        mDiets.add(new Diet("Wafers",120,45,51));
        mDiets.add(new Diet("Kebab(1 plate)",150,43,53));
        mDiets.add(new Diet("Mozzarella cheese(28 g)",80,45,51));
        mDiets.add(new Diet("Beef,chest,cooked(85 g)",189,43,53));
        mDiets.add(new Diet("Shawarma,only meat",317,43,53));
        mDiets.add(new Diet("Crab,canned",84,43,53));
        mDiets.add(new Diet("Fish",136,43,53));
        mDiets.add(new Diet("Chicken Crispy",270,43,53));
        mDiets.add(new Diet("Chicken noodles",243,43,53));
        mDiets.add(new Diet("Quid(1 plate)",285,43,53));
        mDiets.add(new Diet("Mutton kebab",314,43,53));
        mDiets.add(new Diet("Mutton Biryani",275,43,53));
        mDiets.add(new Diet("Chicken Biryani",262,43,53));
    }
}
