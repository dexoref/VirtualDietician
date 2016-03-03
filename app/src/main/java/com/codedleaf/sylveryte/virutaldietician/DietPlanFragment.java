package com.codedleaf.sylveryte.virutaldietician;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sylveryte on 14/2/16.
 */
public class DietPlanFragment extends Fragment {

    private int mTableIndex;
    private ViewGroup mContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.diet_plan_fragment_layout,container,false);
        mContainer=container;
        final TableLayout table=(TableLayout)view.findViewById(R.id.tabledietplan);
        Button generateButton=(Button)view.findViewById(R.id.generateButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DietPlan.getInstance().generatePlan();
                updateUI(table);
            }
        });

        updateUI(table);



        return view;
    }

    private void updateUI(TableLayout table) {

        mTableIndex=0;
        DietPlan dietPlan=DietPlan.getInstance();


        //dietPlan.generatePlan();

        table.removeAllViews();

        setTitle("Breakfast", table);
        setViews(dietPlan.getBreakfast(), table);
        setTitle("Lunch", table);
        setViews(dietPlan.getMlunch(), table);
        setTitle("Dinner", table);
        setViews(dietPlan.getDinner(), table);
    }

    private void setViews(List<Diet> diets,TableLayout table) {


        LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
        for (int i=0;i<diets.size();i++) {

            Diet diet=diets.get(i);

            View itemView=layoutInflater.inflate(R.layout.diet_single_list,mContainer,false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Change this diet?")
                            .setMessage("Are you sure you want to Change?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    
                                    
                                    //change code
                                    // FIXME: 3/3/16 
                                    
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    
                                    
                                    //do nothing

                                }
                            })
                            .show();
                }
            });
            TextView mTitleTextView=(TextView)itemView.findViewById(R.id.textViewDietTitle);
            TextView mDlb=(TextView)itemView.findViewById(R.id.textDlb);
            TextView mVen=(TextView)itemView.findViewById(R.id.textVen);
            TextView mCal=(TextView)itemView.findViewById(R.id.textCal);

            //set
            mTitleTextView.setText(diet.getDietName());



            mVen.setText(diet.getStringVen());
            mDlb.setVisibility(TextView.GONE);

            if(diet.getVen()==Diet.VEGETARIAN) {
                mVen.setTextColor(Color.parseColor("#00FF00"));
            }
            if(diet.getVen()==Diet.NONVEGETARIAN)
            {
                mVen.setTextColor(Color.parseColor("#FF0000"));
            }
            if(diet.getVen()==Diet.EGGETARIAN)
            {
                mVen.setTextColor(Color.parseColor("#FFA500"));
            }
            mCal.setText(String.format("%s calories", diet.getCalories()));

            table.addView(itemView,mTableIndex++);
        }
    }

    private void setTitle(String title,TableLayout table) {
        TextView textView=new TextView(getActivity());
        textView.setPadding(0, 20, 0, 0);
        textView.setTextSize(35);
        textView.setText(title);
        table.addView(textView,mTableIndex++);
    }

    public static Fragment newInstance() {
        return new DietPlanFragment();
    }

}
