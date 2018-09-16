package com.example.joyprakash.infinitecycleviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class HorizontalPagerAdapter extends PagerAdapter {
    private List<Integer> images;
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> names;

    public HorizontalPagerAdapter(List<Integer> images, List<String> names, Context context) {
        this.images = images;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.child_item,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position));
//        Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
        container.addView(view);
        return view;
    }
}
