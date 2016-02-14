package com.codedleaf.sylveryte.virutaldietician;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view=inflater.inflate(R.layout.dieta_plan_fragment_layout,container,false);
        return view;
    }

    public static Fragment newInstance() {
        return new DietPlanFragment();
    }

}
