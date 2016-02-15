package com.codedleaf.sylveryte.virutaldietician;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sylveryte on 14/2/16.
 */
public class DietPlanFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.diet_plan_fragment_layout,container,false);

        TableLayout table=(TableLayout)view.findViewById(R.id.tabledietplan);


        int k=0;
        List<Diet> diets=DietLab.get().getDiets();
        for (int i=0;i<16&&i<diets.size();i++)
        {
            TextView textView=new TextView(getActivity());
            if(i==0)
            {
                textView.setPadding(0,20,0,0);
                textView.setTextSize(35);
                textView.setText("Breakfast");
            }else if(i==5)
            {
                textView.setPadding(0,20,0,0);
                textView.setTextSize(35);
                textView.setText("lunch");
            }else if(i==10)
            {
                textView.setPadding(0,20,0,0);
                textView.setTextSize(35);
                textView.setText("Diner");
            }else
            {
                textView.setPadding(20,10,0,0);
                textView.setText(String.format("%s\n%s", diets.get(i).getDietName(),diets.get(i).getCalories()));
            }
            table.addView(textView,i);
            k=i;
        }

        for (int i=k+1;i<k+2;i++)
        {
            TextView textView=new TextView(getActivity());
                textView.setPadding(0, 10, 0, 0);
                textView.setTextSize(35);
                textView.setText("\n");

            table.addView(textView,i);

        }

        return view;
    }

    public static Fragment newInstance() {
        return new DietPlanFragment();
    }

}
