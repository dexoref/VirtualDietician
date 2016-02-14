package com.codedleaf.sylveryte.virutaldietician;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * Created by sylveryte on 14/2/16.
 */
public class DietLab {
    private static DietLab sDietLab;
    private List<Diet> mDiets;
    private Workbook mWorkbook;
    private Sheet mSheet;
    private File mFile;
    private HSSFWorkbook newWorkbook;
    private HSSFSheet sheet;
    FileInputStream hs;

    FileInputStream dj;

    private void setDiets()
    {
        try {
            mFile=new File("diets.xls");

            if(mFile.exists())
            {

                hs = new FileInputStream(mFile);

            }

            dj = new FileInputStream("diets.xls");


            Diet diet=new Diet("sdaf",32);
            String s=new String(diet.getDietName());
            String sd=new String(diet.getDietName());

//            newWorkbook=new HSSFWorkbook(myfileInputStream);
//            sheet=newWorkbook.getSheetAt(0);
//            mWorkbook=Workbook.getWorkbook(mFile);
//            mSheet=mWorkbook.getSheet(0);
//            Cell cell=mSheet.getCell(2,2);
//            mDiets.add(new Diet(cell.getContents(),15.6));
        }catch (Exception e)
        {

        }

    }

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
        setDiets();
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
