package com.example.imagegallary;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ShareImage> imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        imgs = new ArrayList<ShareImage>();
        // imgs.add(new Images("img1",R.drawable.aaaa));
        //  imgs.add(new Images("img1",R.drawable.b));
        imgs.add(new ShareImage("img1","Details 1","45", R.drawable.j));
        imgs.add(new ShareImage("img2","Details 11","445", R.drawable.d));
        imgs.add(new ShareImage("img3","Details 11","454", R.drawable.e));
        imgs.add(new ShareImage("img3333","Details 1111","454", R.drawable.all));
//        imgs.add(new Images("img4","415", R.drawable.f));
//        imgs.add(new Images("img5","451", R.drawable.g));
//        imgs.add(new Images("img6","445", R.drawable.h));
//        imgs.add(new Images("img7","145", R.drawable.i));

        //  imgs.add(new Images("img1",R.drawable.aaaa));
        //  imgs.add(new Images("img1",R.drawable.b));
//        imgs.add(new Images("img10","0145", R.drawable.j));
//        imgs.add(new Images("img11","475", R.drawable.d));
//        imgs.add(new Images("img12","445", R.drawable.e));
//        imgs.add(new Images("img13","4175", R.drawable.f));
//        imgs.add(new Images("img14","475", R.drawable.g));
//        imgs.add(new Images("img15","88", R.drawable.h));
//        imgs.add(new Images("img16","4885", R.drawable.i));

        //TextView t=new TextView(getApplicationContext());

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, imgs);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myadapter);


      /*  int rotation = getWindowManager().getDefaultDisplay().getRotation();

        Configuration config = getResources().getConfiguration();
        int naturalOrientation;

        if (((rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) &&
                config.orientation == Configuration.ORIENTATION_LANDSCAPE)
                || ((rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) &&
                config.orientation == Configuration.ORIENTATION_PORTRAIT)) {
            naturalOrientation = Configuration.ORIENTATION_LANDSCAPE;
        } else {
            naturalOrientation = Configuration.ORIENTATION_PORTRAIT;
        }

        // because getRotation() gives "rotation from natural orientation" of device (different on phone and tablet)
        // we need to update rotation variable if natural orienation isn't 0 (mainly tablets)
        if (naturalOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            rotation = ++rotation % 4;

            switch (rotation) {
                case Surface.ROTATION_0: //0
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    break;
                case Surface.ROTATION_90: //1
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    break;
                case Surface.ROTATION_180: //2
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                    break;
                case Surface.ROTATION_270: //3
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                    break;
            }
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }*/
    }




}
