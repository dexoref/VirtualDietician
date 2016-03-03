package com.codedleaf.sylveryte.virutaldietician;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sylveryte on 3/3/16.
 */
public class ShoppingFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ShopAdapter mAdapter;
    private List<ShoppingItem> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.shopping_layout,container,false);

        final EditText etName=(EditText)view.findViewById(R.id.editTextItemName);
        final EditText etex=(EditText)view.findViewById(R.id.editTextExtraInfo);
        final EditText etqt=(EditText)view.findViewById(R.id.editTextQuantity);
        Button button=(Button)view.findViewById(R.id.additembutton);



        mRecyclerView=(RecyclerView)view.findViewById(R.id.shop_recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mItems=ShoppingLab.get().getItems();

        mAdapter=new ShopAdapter();
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingLab.get().addShoppingItem(new ShoppingItem(
                        etName.getText().toString(),
                        Integer.parseInt(etqt.getText().toString()),
                        etex.getText().toString()
                ));
                etName.setText("");
                etex.setText("");
                etqt.setText("");
                mAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    private class ShoppingHolder extends RecyclerView.ViewHolder
    {
        ShoppingItem mShoppingItem;
        TextView name;
        TextView extr;
        CheckBox pue;

        public ShoppingHolder(View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    new AlertDialog.Builder(getActivity())
                            .setTitle("Delete " + mShoppingItem.getItemName() + "?")
                            .setMessage("Are you sure you want to delete?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //delete
                                    ShoppingLab.get().deleteShoppingItem(mShoppingItem);
                                    mAdapter.notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing

                                }
                            })
                            .show();

                    return false;
                }
            });

            name=(TextView)itemView.findViewById(R.id.ItemName);
            extr=(TextView)itemView.findViewById(R.id.extra);
            pue=(CheckBox)itemView.findViewById(R.id.checkBox);

            pue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mShoppingItem.setIsPurcahsed(isChecked);
                    ShoppingLab.get().updateShoppingItem(mShoppingItem);
                }
            });

        }

        public void bind(ShoppingItem item)
        {
            mShoppingItem=item;
            name.setText(mShoppingItem.getItemName());
            extr.setText(mShoppingItem.getExtraInfo());
            pue.setChecked(mShoppingItem.isPurcahsed());
        }
    }

    private class ShopAdapter extends RecyclerView.Adapter<ShoppingHolder>
    {
        @Override
        public ShoppingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            final View view=layoutInflater.inflate(R.layout.shop_single_list,parent,false);
            return new ShoppingHolder(view);
        }

        @Override
        public void onBindViewHolder(ShoppingHolder holder, int position) {

            holder.bind(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    public static Fragment newInstance() {
        return new ShoppingFragment();
    }
}
