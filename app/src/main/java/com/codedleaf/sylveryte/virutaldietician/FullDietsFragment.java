package com.codedleaf.sylveryte.virutaldietician;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sylveryte on 15/2/16.
 */
public class FullDietsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private DietAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.diets_recycle_view_layout,container,false);

        mRecyclerView=(RecyclerView)view.findViewById(R.id.diets_recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUi();

        return view;
    }

    private void updateUi()
    {
        List<Diet> diets=DietLab.get().getDiets();

        mAdapter=new DietAdapter(diets);
        mRecyclerView.setAdapter(mAdapter);
    }


    private class DietHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;
        public TextView mDlb;
        public TextView mVen;
        public TextView mCal;

        public DietHolder(View itemView)
        {
            super(itemView);

            mTitleTextView=(TextView)itemView.findViewById(R.id.textViewDietTitle);
            mDlb=(TextView)itemView.findViewById(R.id.textDlb);
            mVen=(TextView)itemView.findViewById(R.id.textVen);
            mCal=(TextView)itemView.findViewById(R.id.textCal);

        }

    }
    private class DietAdapter extends RecyclerView.Adapter<DietHolder>
    {
        private List<Diet> mDiets;
        public DietAdapter(List<Diet> diets)
        {
            mDiets=diets;
        }

        @Override
        public DietHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.diet_single_list,parent,false);
            return new DietHolder(view);
        }

        @Override
        public void onBindViewHolder(DietHolder holder, int position) {
            Diet diet=mDiets.get(position);
            holder.mTitleTextView.setText(diet.getDietName());



            holder.mVen.setText(diet.getStringVen());
            holder.mDlb.setText(diet.getStringDlb());

            if(diet.getVen()==Diet.VEGETARIAN) {
                holder.mVen.setTextColor(Color.parseColor("#00FF00"));
            }
            if(diet.getVen()==Diet.NONVEGETARIAN)
            {
                holder.mVen.setTextColor(Color.parseColor("#FF0000"));
            }
            if(diet.getVen()==Diet.EGGETARIAN)
            {
                holder.mVen.setTextColor(Color.parseColor("#FFA500"));
            }
            holder.mCal.setText(String.format("%s", diet.getCalories()));
        }

        @Override
        public int getItemCount() {
            return mDiets.size();
        }
    }

    public static Fragment newInstance() {
        return new FullDietsFragment();
    }
}
