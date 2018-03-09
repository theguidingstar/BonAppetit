package com.example.yashshah.bonappetit;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    private SparseBooleanArray mCheckStates;
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;

    private ArrayList<contactdetail> contactdetailList = null;
    private ArrayList<contactdetail> arraylist;
    ArrayList<String> mArrayListAll;
    ArrayList<String> mArrayListmatches;

    public ListViewAdapter(Context context, ArrayList<contactdetail> contactdetailList,ArrayList<String> mArrayListAll,ArrayList<String> mArrayListmatches) {
        mContext = context;
        mCheckStates = new SparseBooleanArray(mArrayListAll.size());
        this.contactdetailList = contactdetailList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<contactdetail>();
        this.arraylist.addAll(contactdetailList);
        this.mArrayListAll=mArrayListAll;
        this.mArrayListmatches=mArrayListmatches;

    }

    public class ViewHolder {
        TextView Name;
        TextView Number;
    }

    @Override
    public int getCount() {
        return contactdetailList.size();
    }

    @Override
    public contactdetail getItem(int position) {
        return contactdetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);
            // Locate the TextViews in listview_item.xml
            holder.Name = (TextView) view.findViewById(R.id.textView);
            holder.Number = (TextView) view.findViewById(R.id.textView2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        for (int i = 0; i < mArrayListmatches.size(); i++) {
            holder.Name.setText(contactdetailList.get(position).getName());
            holder.Number.setText(contactdetailList.get(position).getNumber());
            Button button=(Button) view.findViewById(R.id.button);
            CheckBox cb=(CheckBox) view.findViewById(R.id.checkBox);

            if (mArrayListmatches.get(i).contains(contactdetailList.get(position).getNumber())) {

                System.out.println("jvs contains...."+mArrayListmatches.get(i)+"----"+contactdetailList.get(position).getNumber());
                holder.Name.setTextColor(Color.RED);
                cb.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
                cb.setTag(position);
                cb.setChecked(mCheckStates.get(position, false));
                cb.setOnCheckedChangeListener(this);

               break;
            }

            else
            {
                holder.Name.setTextColor(Color.BLACK);
                button.setVisibility(View.VISIBLE);
                cb.setVisibility(View.GONE);
            }

        }
        return view;
    }

    public boolean isChecked(int position) {
        return mCheckStates.get(position, false);
    }

    public void setChecked(int position, boolean isChecked) {
        mCheckStates.put(position, isChecked);
        System.out.println("hello...........");
        notifyDataSetChanged();
    }

    public void toggle(int position) {
        setChecked(position, !isChecked(position));
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView,
                                 boolean isChecked) {
        // TODO Auto-generated method stub

        mCheckStates.put((Integer) buttonView.getTag(), isChecked);
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        contactdetailList.clear();
        if (charText.length() == 0) {
            contactdetailList.addAll(arraylist);
        }
        else
        {
            for (contactdetail wp : arraylist)
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    contactdetailList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
