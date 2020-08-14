package org.tensorflow.lite.examples.classification.adapters;

import android.widget.ImageView;

import org.tensorflow.lite.examples.classification.models.Place;


public interface PlaceItemClickListener {


    void onPlaceClick(Place place, ImageView placeImageView); // we will need the imageView to make the shared animation between two activity

}
