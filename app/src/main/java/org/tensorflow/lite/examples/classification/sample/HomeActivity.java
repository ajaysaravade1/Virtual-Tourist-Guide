package org.tensorflow.lite.examples.classification.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.tensorflow.lite.examples.classification.ClassifierActivity;
import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.fragments.ActivitiesFragment;
import org.tensorflow.lite.examples.classification.fragments.ExploreFragment;
import org.tensorflow.lite.examples.classification.fragments.ProfileFragment;
import org.tensorflow.lite.examples.classification.fragments.ServicesFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    String currentImagePath=null;
    private static final int IMAGE_REQUEST=1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    selectedFragment=new ExploreFragment();
                    break;
                case R.id.navigation_activities:
                    selectedFragment=new ActivitiesFragment();
                    break;
                case R.id.navigation_camera:
                  //  selectedFragment=new CameraFragment();

                   // captureImage();
                    //displayImage();
                    startActivity(new Intent(HomeActivity.this, ClassifierActivity.class));
                    break;
                case R.id.navigation_services:
                    selectedFragment=new ServicesFragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment=new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        getSupportActionBar().hide();

        //default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ExploreFragment()).commit();
    }


/*
    ////camera/
    public void captureImage(){
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getPackageManager())!=null){
            File imageFile=null;
            try {
                imageFile=getImageFile();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if(imageFile!=null){
                Uri imageUri= FileProvider.getUriForFile(this,"com.example.android.fileprovider",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);

                startActivityForResult(cameraIntent,IMAGE_REQUEST);
            }
        }

    }

    public void displayImage(){
        Intent intent=new Intent(this,DisplayImageActivity.class);
        intent.putExtra("image_path",currentImagePath);
        startActivity(intent);

    }

    private File getImageFile() throws IOException {
        String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName="jpg_"+timeStamp+"_";
        File storageDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile= File.createTempFile(imageName,".jpg",storageDir);
        currentImagePath=imageFile.getAbsolutePath();
        return imageFile;
    }
*/

}
