package com.codedleaf.sylveryte.virutaldietician;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sylveryte on 15/2/16.
 */
public class AddDietFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.add_diet_fragment_layout,container,false);

        final EditText editTextTitle=(EditText)view.findViewById(R.id.editTextTitle);
        final EditText editTextCals=(EditText)view.findViewById(R.id.editText2cals);
        final Spinner spinnerDlb=(Spinner)view.findViewById(R.id.spinnerDLB);
        final Spinner spinnerVen=(Spinner)view.findViewById(R.id.spinnerVEN);

        final Button button=(Button)view.findViewById(R.id.buttonAddDiet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dlb;
                int ven;
                switch (spinnerDlb.getSelectedItemPosition())
                {
                    case 0: dlb=Diet.BREAKFAST; break;
                    case 1: dlb=Diet.LUNCH; break;
                    case 2: dlb=Diet.DINNER; break;
                    case 3: dlb=Diet.ANYTIME; break;
                    default: dlb=Diet.ANYTIME; break;
                }

                switch (spinnerVen.getSelectedItemPosition())
                {
                    case 0: ven=Diet.VEGETARIAN; break;
                    case 1: ven=Diet.EGGETARIAN; break;
                    case 2: ven=Diet.NONVEGETARIAN; break;
                    default: ven=Diet.VEGETARIAN; break;
                }

                Diet diet = new Diet(editTextTitle.getText().toString(),
                        Double.parseDouble(editTextCals.getText().toString()), dlb, ven
                );
                DietLab.get().add(diet);

                Toast.makeText(getActivity(), "Record Added", Toast.LENGTH_SHORT).show();
                button.setEnabled(false);
            }
        });



        List<String> dlbs=new ArrayList<>();
                    dlbs.add("Breakfast");
                    dlbs.add("Lunch");
                    dlbs.add("Dinner");
                    dlbs.add("Anytime");
        ArrayAdapter<String> dlbAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,dlbs);
        dlbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDlb.setAdapter(dlbAdapter);


        List<String> vens=new ArrayList<>();
                    vens.add("Vegetarian");
                    vens.add("Eggetarian");
                    vens.add("Non-Vegetarian");
        ArrayAdapter<String> venAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,vens);
        venAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVen.setAdapter(venAdapter);


        return view;
    }

    public static Fragment newInstance() {
        return new AddDietFragment();
    }
}
