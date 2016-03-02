package com.codedleaf.sylveryte.virutaldietician;

import android.app.ProgressDialog;
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
        final RadioGroup radioGroup=(RadioGroup)view.findViewById(R.id.radioGroupMaleFemale);

        final TextView namet=(TextView)view.findViewById(R.id.editTextUserNamet);
        final TextView heightt=(TextView)view.findViewById(R.id.editText_heightt);
        final TextView weightt=(TextView)view.findViewById(R.id.editText_weightt);
        final TextView aget=(TextView)view.findViewById(R.id.editText_aget);
        final TextView radioGroupt=(TextView)view.findViewById(R.id.radioGroupMaleFemalet);

        final RadioButton radioButtonM=(RadioButton)view.findViewById(R.id.radioButtonMale);
        final RadioButton radioButtonF=(RadioButton)view.findViewById(R.id.radioButtonFemale);
        final Button submit=(Button)view.findViewById(R.id.submitButton);
        final Spinner spinnerwant=(Spinner)view.findViewById(R.id.spinnerIwantTo);
        final Button editButton=(Button)view.findViewById(R.id.editButton);
        final TextView bmiText=(TextView)view.findViewById(R.id.bmiRemark);
        final TextView bmrText=(TextView)view.findViewById(R.id.bmrRemark);


        updateUi(user, name, height, weight, age, radioButtonM, radioButtonF, spinnerwant, bmiText, bmrText,namet,heightt,weightt,aget,radioGroupt);




        //uiCode
        List<String> wantTo=new ArrayList<>();
        wantTo.add("I'm fit.");
        wantTo.add("I want to gain weight.");
        wantTo.add("I want to loose weight.");
        ArrayAdapter<String> dlbAdapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, wantTo);
        dlbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerwant.setAdapter(dlbAdapter);


        spinnerwant.setEnabled(false);
        submit.setVisibility(Button.GONE);



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setVisibility(EditText.VISIBLE);
                height.setVisibility(EditText.VISIBLE);
                weight.setVisibility(EditText.VISIBLE);
                age.setVisibility(EditText.VISIBLE);
                radioGroup.setVisibility(RadioGroup.VISIBLE);

                submit.setVisibility(Button.VISIBLE);
                editButton.setVisibility(Button.GONE);
                namet.setVisibility(TextView.GONE);
                heightt.setVisibility(TextView.GONE);
                weightt.setVisibility(TextView.GONE);
                aget.setVisibility(TextView.GONE);
                radioGroupt.setVisibility(RadioGroup.GONE);
                spinnerwant.setEnabled(true);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ProgressDialog dialog=new ProgressDialog(getActivity());
                dialog.setMessage("Calculating!");
                dialog.setCancelable(false);
                dialog.setInverseBackgroundForced(false);
                dialog.show();

                submit.setVisibility(Button.GONE);

                name.setVisibility(EditText.GONE);
                height.setVisibility(EditText.GONE);
                weight.setVisibility(EditText.GONE);
                age.setVisibility(EditText.GONE);
                radioGroup.setVisibility(RadioGroup.GONE);

                editButton.setVisibility(Button.VISIBLE);
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



                updateUi(user, name, height, weight, age, radioButtonM, radioButtonF, spinnerwant, bmiText, bmrText,namet,heightt,weightt,aget,radioGroupt);

                boolean bdis=false;
                namet.setVisibility(TextView.VISIBLE);
                heightt.setVisibility(TextView.VISIBLE);
                weightt.setVisibility(TextView.VISIBLE);
                aget.setVisibility(TextView.VISIBLE);
                radioGroupt.setVisibility(TextView.VISIBLE);
                spinnerwant.setEnabled(bdis);
                DietLab.get().writeDownDB();

                dialog.hide();

            }
        });

        return view;
    }

    private void updateUi(User user, EditText name, EditText height, EditText weight, EditText age, RadioButton radioButtonM, RadioButton radioButtonF, Spinner spinnerwant,TextView bmiText,TextView bmrText
    ,TextView namet,TextView heightt,TextView weightt,TextView aget,TextView radioGroupt) {

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


        namet.setText(user.getUserName());
        heightt.setText(String.format("%s", user.getHeight()));
        weightt.setText(String.format("%s", user.getWeight()));
        aget.setText(String.format("%d", user.getAge()));
        if(user.isMale())
        {
            radioGroupt.setText("Male");
        }else
        {
            radioGroupt.setText("Female");
        }
    }


    public static Fragment newInstance() {
        return new UserFragment();
    }
}
