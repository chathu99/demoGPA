package com.example.imagegallary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFull extends AppCompatActivity {


    private TextView fulltxt;
    private ImageView fullimg;
    Intent intent;
    String Title,Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);

        fulltxt=(TextView) findViewById(R.id.textView);
        fullimg=(ImageView) findViewById(R.id.imageView);

         intent=getIntent();
         Title=intent.getExtras().getString("Title");
        Price=intent.getExtras().getString("Price");
        int Thumbnale=intent.getExtras().getInt("Thumbnale");

        fulltxt.setText(Title);
        fullimg.setImageResource(Thumbnale);


    }


    public Intent setIN(){
        intent=getIntent();
        return intent;
    }

    private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_share, menu);

        // Locate MenuItem with ShareActionProvider
       // MenuItem item = menu.findItem(R.id.menu_item_share);

        // Fetch and store ShareActionProvider
       //  mShareActionProvider = (ShareActionProvider) item.getActionProvider();
         // mShareActionProvider.setShareIntent(setIN());

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_item_share:
                shareContent();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareContent(){
        Bitmap bitmap=getBitmapFromView(fullimg);
        Log.d("bitmap","  bitmap "+String.valueOf(bitmap));
        try{
            String PriductDetails=Title+ " "+Price+"  "+"\n shared by";
            File file=new File(this.getExternalFilesDir(null),Title+".png");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            file.setReadable(true,false);
            final Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_TEXT,PriductDetails);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/*");
            startActivity(Intent.createChooser(intent,"share image"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private Bitmap getBitmapFromView(View view){
        Bitmap returnedBitmap=Bitmap.createBitmap(view.getMeasuredWidth(),view.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(returnedBitmap);
        Drawable bgdrawable=view.getBackground();

        if(bgdrawable!=null){
            bgdrawable.draw(canvas);


        }else{
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;

    }



    // Call to update the share intent
   /* private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }*/
}
