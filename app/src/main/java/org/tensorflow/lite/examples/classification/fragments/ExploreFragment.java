package org.tensorflow.lite.examples.classification.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.adapters.PlaceItemClickListener;
import org.tensorflow.lite.examples.classification.adapters.SliderPagerAdapter;
import org.tensorflow.lite.examples.classification.models.Place;
import org.tensorflow.lite.examples.classification.models.Slide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExploreFragment extends Fragment implements PlaceItemClickListener {


    private List<Slide> lstSlides;
    private ViewPager sliderPager;

    private TabLayout indicator;

    private RecyclerView PlaceRv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_explore,container,false);

        iniViews(view);
        iniSlider();



        return view;
    }



    private void iniSlider() {
        //prepare a list of slides...
        lstSlides=new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.beach,"Beaches"));
        lstSlides.add(new Slide(R.drawable.church,"Churches "));
        lstSlides.add(new Slide(R.drawable.religious,"Religious"));
        lstSlides.add(new Slide(R.drawable.waterfall,"Waterfalls"));
        //lstSlides.add(new Slide(R.drawable.beach,"The Conjuring"));
      //  lstSlides.add(new Slide(R.drawable.beach,"Interstellar"));


        ///  prepare a list of slides ...
        SliderPagerAdapter adapter=new SliderPagerAdapter(getContext(),lstSlides);
        sliderPager.setAdapter(adapter);
        /// setup time
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new sliderTimer(),2000,3000);
        indicator.setupWithViewPager(sliderPager,true);
    }
    private void iniViews(View view) {
        sliderPager=view.findViewById(R.id.slider_pager);
        indicator=view.findViewById(R.id.indicator);
       // PlaceRv=getView().findViewById(R.id.rv  );

       // movieRvWeek=findViewById(R.id.rv_movies_week);



    }

    @Override
    public void onPlaceClick(Place place, ImageView placeImageView) {
        /// here we send movie information to detail activity
        // also we will create the transition animation between the two activity

        Toast.makeText(getContext(),"click works : "+place.getName().toString(), Toast.LENGTH_SHORT).show();

       /* Intent intent=new Intent(this,MovieDetailActivity.class);
        //Send movie information
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());*/

        ///Animations
       /* ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                placeImageView,"sharedName");*/
        //startActivity(intent,options.toBundle());

    }


    class sliderTimer extends TimerTask {

        @Override
        public void run() {
            try {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(sliderPager.getCurrentItem()<lstSlides.size()-1){
                            sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                        }
                        else {
                            sliderPager.setCurrentItem(0);
                        }
                    }
                });
            }
            catch (Exception e){

            }

        }
    }

}
