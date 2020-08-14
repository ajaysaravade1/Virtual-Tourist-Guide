package org.tensorflow.lite.examples.classification.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.tensorflow.lite.examples.classification.R;

public class PlaceActivityDemo extends AppCompatActivity {


    TextView txtPlaceName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_demo);

        txtPlaceName=findViewById(R.id.txt_place_name);
        String placeName = getIntent().getExtras().getString("placeName");
        txtPlaceName.setText(placeName);
    }
}
