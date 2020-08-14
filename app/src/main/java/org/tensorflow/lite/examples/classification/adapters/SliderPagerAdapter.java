package org.tensorflow.lite.examples.classification.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.models.Slide;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mcontext;
    private List<Slide> mList;


    public SliderPagerAdapter(Context mcontext, List<Slide> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout=inflater.inflate(R.layout.slide_item,null);

        ImageView slideImg=slideLayout.findViewById(R.id.slider_img);
        TextView slideText=slideLayout.findViewById(R.id.slider_title);
        slideImg.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
