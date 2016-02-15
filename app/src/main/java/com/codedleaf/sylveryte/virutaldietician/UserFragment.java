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
import android.widget.TextView;

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
        final Button editButton=(Button)view.findViewById(R.id.editButton);
        final TextView bmiText=(TextView)view.findViewById(R.id.bmiRemark);
        final TextView bmrText=(TextView)view.findViewById(R.id.bmrRemark);


        updateUi(user, name, height, weight, age, radioButtonM, radioButtonF, spinnerwant,bmiText,bmrText);

        //uiCode
        List<String> wantTo=new ArrayList<>();
        wantTo.add("I'm fit.");
        wantTo.add("I want to gain weight.");
        wantTo.add("I want to loose weight.");
        ArrayAdapter<String> dlbAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, wantTo);
        dlbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerwant.setAdapter(dlbAdapter);

        boolean bdis=false;
        name.setEnabled(bdis);
        height.setEnabled(bdis);
        weight.setEnabled(bdis);
        age.setEnabled(bdis);
        radioButtonF.setEnabled(bdis);
        radioButtonM.setEnabled(bdis);
        spinnerwant.setEnabled(bdis);
        submit.setVisibility(Button.INVISIBLE);



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit.setVisibility(Button.VISIBLE);
                editButton.setVisibility(Button.INVISIBLE);
                boolean bdis=true;
                name.setEnabled(bdis);
                height.setEnabled(bdis);
                weight.setEnabled(bdis);
                age.setEnabled(bdis);
                radioButtonF.setEnabled(bdis);
                radioButtonM.setEnabled(bdis);
                spinnerwant.setEnabled(bdis);
            }
        });

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


                DietLab.get().writeDownDB();
                submit.setVisibility(Button.INVISIBLE);
                editButton.setVisibility(Button.VISIBLE);
                updateUi(user, name, height, weight, age, radioButtonM, radioButtonF, spinnerwant, bmiText, bmrText);

                boolean bdis=false;
                name.setEnabled(bdis);
                height.setEnabled(bdis);
                weight.setEnabled(bdis);
                age.setEnabled(bdis);
                radioButtonF.setEnabled(bdis);
                radioButtonM.setEnabled(bdis);
                spinnerwant.setEnabled(bdis);

            }
        });

        return view;
    }

    private void updateUi(User user, EditText name, EditText height, EditText weight, EditText age, RadioButton radioButtonM, RadioButton radioButtonF, Spinner spinnerwant,TextView bmiText,TextView bmrText) {

        //updateUI
        user.updateUserCalculation();

        bmiText.setText(user.getBMIStringRemark());
        bmrText.setText(String.format("You must eat %.2f calories everyday.", user.getBMR()));


        name.setText(user.getUserName());
        short i=0;
        if(user.getWantTo()== User.GainWeight)
        {
            i=1;
        }else if(user.getWantTo()== User.LooseWeight)
        {
            i=2;
        }
        spinnerwant.setSelection(i);

        height.setText(String.format("%s", user.getHeight()));
        weight.setText(String.format("%s", user.getWeight()));
        age.setText(String.format("%d", user.getAge()));
        if(user.isMale())
        {
            radioButtonM.setChecked(true);
        }else
        {
            radioButtonF.setChecked(true);
        }
    }


    public static Fragment newInstance() {
        return new UserFragment();
    }
}
