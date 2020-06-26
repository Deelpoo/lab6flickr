package com.example.lab6flickr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    List<String> mTitle;
    List<String> mPublished;
    List<String> mImagesUrl;
    Context context;

    public MyAdapter(@NonNull Context context, List<String> titles, List<String> publisheds, List<String> imagesUrl) {
        super(context, R.layout.listview_activity);
        this.context = context;
        this.mTitle = titles;
        this.mPublished = publisheds;
        this.mImagesUrl = imagesUrl;
    }

    @Override
    public int getCount() {
        return mTitle.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.listview_activity, parent, false);
            mViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            mViewHolder.tvPublished = (TextView) convertView.findViewById(R.id.published);
            mViewHolder.iv = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.tvTitle.setText(mTitle.get(position));
        mViewHolder.tvPublished.setText(mPublished.get(position));
        Picasso.get().load(mImagesUrl.get(position)).into(mViewHolder.iv);

        return convertView;
    }

    static class ViewHolder{
        TextView tvTitle;
        TextView tvPublished;
        ImageView iv;
    }
}
