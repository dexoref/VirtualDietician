package com.codedleaf.sylveryte.virutaldietician;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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



        //updateUI
        name.setText(user.getUserName());
        Diet diet=(Diet)DietLab.get().getDiets().get(0);
        name.setText(diet.getDietName());

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
