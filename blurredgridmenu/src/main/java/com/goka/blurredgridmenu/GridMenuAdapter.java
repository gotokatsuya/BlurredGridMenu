package com.goka.blurredgridmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by katsuyagoto on 2014/06/19.
 */
public class GridMenuAdapter extends ArrayAdapter<MenuItem> {

    private LayoutInflater mInflater;

    public GridMenuAdapter(Context context) {
        super(context, 0);
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_grid_menu, null, false);

            holder = new Holder();
            holder.menuTitle = (TextView) convertView.findViewById(R.id.item_grid_title);
            holder.menuIcon = (SquaredImageView) convertView.findViewById(R.id.item_grid_icon);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.menuTitle.setText(getItem(position).title);
        holder.menuIcon.setImageResource(getItem(position).icon);

        return convertView;
    }

    static class Holder {

        TextView menuTitle;

        SquaredImageView menuIcon;
    }

}
