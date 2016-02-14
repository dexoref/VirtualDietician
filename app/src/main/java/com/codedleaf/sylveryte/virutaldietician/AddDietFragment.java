package com.codedleaf.sylveryte.virutaldietician;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

        Button button=(Button)view.findViewById(R.id.buttonAddDiet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diet diet = new Diet(editTextTitle.getText().toString(),
                                    Double.parseDouble(editTextCals.getText().toString()),45,51
                                    );
                DietLab.get().addDiet(diet);
            }
        });

        return view;
    }

    public static Fragment newInstance() {
        return new AddDietFragment();
    }
}
