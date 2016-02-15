package com.codedleaf.sylveryte.virutaldietician;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sylveryte on 14/2/16.
 */
public class UserFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.user_fragment_layout, container, false);

        final User user=User.getInstance();

        final EditText name=(EditText)view.findViewById(R.id.editTextUserName);
        final EditText height=(EditText)view.findViewById(R.id.editText_height);
        final EditText weight=(EditText)view.findViewById(R.id.editText_weight);
        final EditText age=(EditText)view.findViewById(R.id.editText_age);
        final RadioButton radioButtonM=(RadioButton)view.findViewById(R.id.radioButtonMale);
        final RadioButton radioButtonF=(RadioButton)view.findViewById(R.id.radioButtonFemale);
        final Button submit=(Button)view.findViewById(R.id.submitButton);
        final Spinner spinnerwant=(Spinner)view.findViewById(R.id.spinnerIwantTo);


        //uiCode
        List<String> wantTo=new ArrayList<>();
        wantTo.add("I'm fit.");
        wantTo.add("I want to gain weight.");
        wantTo.add("I want to loose weight.");
        ArrayAdapter<String> dlbAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,wantTo);
        dlbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerwant.setAdapter(dlbAdapter);


        //updateUI
        name.setText(user.getUserName());
        Diet diet=(Diet)DietLab.get().getDiets().get(0);
        name.setText(diet.getDietName());
        short i=0;
        if(user.getWantTo()==user.GainWeight)
        {
            i=1;
        }else if(user.getWantTo()==user.LooseWeight)
        {
            i=2;
        }
        spinnerwant.setSelection(i);

        height.setText(user.getHeight() + "");
        weight.setText(user.getWeight() + "");
        age.setText(user.getAge() + "");
        if(user.isMale())
        {
            radioButtonM.setChecked(true);
        }else
        {
            radioButtonF.setChecked(true);
        }




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                user.setUserName(name.getText().toString());
                user.setHeight(Double.parseDouble(height.getText().toString()));
                user.setWeight(Double.parseDouble(weight.getText().toString()));
                user.setAge(Integer.parseInt(age.getText().toString()));

                int i=spinnerwant.getSelectedItemPosition();
                if (i == 1) {

                    user.setWantTo(user.GainWeight);
                }else if (i ==2) {

                    user.setWantTo(user.LooseWeight);
                }

                if (radioButtonM.isChecked())
                {
                    user.setIsMale(true);
                }
                else
                {
                    user.setIsMale(false);
                }

                user.updateUserCalculation();
            }
        });

        return view;
    }



    public static Fragment newInstance() {
        return new UserFragment();
    }
}
