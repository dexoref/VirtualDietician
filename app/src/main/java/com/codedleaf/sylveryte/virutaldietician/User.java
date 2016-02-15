package com.codedleaf.sylveryte.virutaldietician;

/**
 * Created by sylveryte on 14/2/16.
 */
public class User {

    //remark shorts constants
    public static final short Underweight=21;
    public static final short NormalWeight=22;
    public static final short Overweight=23;
    public static final short Obese=24;
    public static final short ReallyObese=25;
    public static final short ExtremelyObese=26;
    public static final short GainWeight=81;
    public static final short NormalUserWeight=80;
    public static final short LooseWeight=79;


    private String mUserName;
    private double  mWeight;
    private double mHeight;
    private int mAge;
    private boolean isMale;
    private double mBMR;
    private double mBMI;
    private short mBMIRemark;
    private short mWantTo;
    private static User sUser;
    private String mBMIStringRemark;


    public static User getInstance() {
        if(sUser==null)
        {
            sUser=new User();
        }
        return sUser;
    }

    private User()
    {
        mUserName="Sylveryte";
        isMale=true;
        mWantTo=NormalUserWeight;
    }

    public void updateUserCalculation()
    {
        mBMR=calculateBMRforMale();
        if(!isMale)
        {
            mBMR-=161;
        }

        if(mWantTo==GainWeight)
        {
            mBMR+=500;
        }else if (mWantTo == LooseWeight) {
            mBMR-=500;
        }

        //setting bmi and bmi remarks
        mBMI=calculateBMI();
        if(mBMI<18.5)
        {
            mBMIRemark=Underweight;
            mBMIStringRemark= String.format("You're under weight, your bmi is %.2f", mBMI);
        }
        else if (mBMI<24.9)
        {
            mBMIRemark=NormalWeight;
            mBMIStringRemark= String.format("You've normal weight, your bmi is %.2f", mBMI);
        }
        else if (mBMI<25.9)
        {
            mBMIRemark=Overweight;
            mBMIStringRemark= String.format("You're over weight, your bmi is %.2f", mBMI);
        }
        else if (mBMI<34.9)
        {
            mBMIRemark=Obese;
            mBMIStringRemark= String.format("You're really over weight, your bmi is %.2f", mBMI);
        }
        else if (mBMI<39.9)
        {
            mBMIRemark=ReallyObese;
            mBMIStringRemark= String.format("You're really really over weight, your bmi is %.2f", mBMI);
        }
        else if (mBMI>39.9)
        {
            mBMIRemark=ExtremelyObese;
            mBMIStringRemark= "Really :/ this much weight, your bmi is " + mBMI;
        }
    }

    public String getBMIStringRemark() {
        return mBMIStringRemark;
    }

    private double calculateBMI() {
        return (mWeight/((mHeight*0.01)*(mHeight*0.01)));
    }

    private double calculateBMRforMale() {
        return 10 * mWeight + 6.25 * mHeight - 5 * mAge + 5;
    }


    public short getWantTo() {
        return mWantTo;
    }

    public void setWantTo(short wantTo) {
        mWantTo = wantTo;
    }

    public short getBMIRemark() {
        return mBMIRemark;
    }

    public double getBMR() {
        return mBMR;
    }

    public double getBMI() {
        return mBMI;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }

    public double getHeight() {
        return mHeight;
    }

    public void setHeight(double height) {
        mHeight = height;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
}
