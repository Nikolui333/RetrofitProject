package com.semenov.retrofitproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.semenov.retrofitproject.R;
import com.semenov.retrofitproject.model.Example;

import java.util.Collections;
import java.util.List;

/**
 * Created by norman on 12/26/16.
 */

public class MyAdapter extends ArrayAdapter<Example> {

    private Context context;
    private Example values;

    public MyAdapter(Context context, Example values) {
        super(context, R.layout.list_item_pagination, Collections.singletonList(values));

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        Example item = values;
        String message = item.getQotdDate();
        textView.setText(message);

        return row;
    }
}
