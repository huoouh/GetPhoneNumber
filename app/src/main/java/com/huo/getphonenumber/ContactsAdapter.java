package com.huo.getphonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by huo on 22/11/2016.
 */

public class ContactsAdapter extends BaseAdapter {

    private Context mContext;
    private List<ContactsInfo> mList;

    public ContactsAdapter(Context context, List<ContactsInfo> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (view == null) {
            view = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.contact_layout, null);

            holder = new ViewHolder();
            holder.mtvName = (TextView)view.findViewById(R.id.tvName);
            holder.mtvNumber = (TextView)view.findViewById(R.id.tvNumber);
            holder.mtvName.setText(mList.get(i).getName());
            holder.mtvNumber.setText(mList.get(i).getNumber());

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }

    private static class ViewHolder {
        public TextView mtvName;
        public TextView mtvNumber;
    }
}
