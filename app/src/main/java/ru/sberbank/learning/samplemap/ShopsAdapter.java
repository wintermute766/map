package ru.sberbank.learning.samplemap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Тичер on 11.05.2017.
 */

public class ShopsAdapter extends BaseAdapter {

    private final List<Address> addresses;

    public ShopsAdapter(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public int getCount() {
        return addresses.size();
    }

    @Override
    public Address getItem(int position) {
        return addresses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater
                .from(parent.getContext());

        TextView view = (TextView) convertView;

        if (view == null) {
            view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1,
                    parent, false);
        }

        view.setText(getItem(position).getAddress());
        return view;
    }
}
