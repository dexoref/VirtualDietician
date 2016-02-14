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

    private String mUserName;
    private double  mWeight;
    private double mHeight;
    private int mAge;
    private boolean isMale;
    private double mBMR;
    private double mBMI;
    private short mBMIRemark;
    private static User sUser;

    public static User getInstance() {
        if(sUser==null)
        {
            sUser=new User();
        }
        return sUser;
    }

    public void updateUserCalculation()
    {
        mBMR=calculateBMRforMale();
        if(!isMale)
        {
            mBMR-=161;
        }

        //setting bmi and bmi remarks
        mBMI=calculateBMI();
        if(mBMI<18.5)
        {
            mBMIRemark=Underweight;
        }
        else if (mBMI<24.9)
        {
            mBMIRemark=NormalWeight;
        }
        else if (mBMI<25.9)
        {
            mBMIRemark=Overweight;
        }
        else if (mBMI<34.9)
        {
            mBMIRemark=Obese;
        }
        else if (mBMI<39.9)
        {
            mBMIRemark=ReallyObese;
        }
        else if (mBMI<24.9)
        {
            mBMIRemark=ExtremelyObese;
        }
    }

    private double calculateBMI() {
        return (mWeight/((mHeight*0.01)*(mHeight*0.01)));
    }

    private double calculateBMRforMale() {
        return 10 * mWeight + 6.25 * mHeight - 5 * mAge + 5;
    }

    private User()
    {
        mUserName="User";
        mHeight=173;
        mWeight=56;
        mAge=20;
        isMale=true;
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
