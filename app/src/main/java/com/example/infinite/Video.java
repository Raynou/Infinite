package com.example.infinite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.infinite.utilidades.Links;


public class Video extends AppCompatActivity {
    VideoView Video;
    Button btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        videoSettings();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hideSystemUI();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {

            hideSystemUI();
        }




    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }



    public void videoSettings(){
        Intent i = getIntent();
        Bundle datos = i.getExtras();
        int ID = (int)datos.get("idv");
        String TakeID="";
        switch (ID)
        {
            case 1:
                TakeID = Links.SHREK;
                break;
            case 2:
                TakeID=Links.SHREK2;
                break;
            case 3:
                TakeID=Links.SHREK3;
                break;
            case 4:
                TakeID = Links.HowTo;
                break;
            case 5:
                TakeID=Links.HowTo2;
                break;
            case 6:
                TakeID=Links.HowTo3;
                break;
            case 7:
                TakeID = Links.SpaceJam;
                break;
            case 8:
                TakeID=Links.Rio;
                break;
            case 9:
                TakeID=Links.TheIncredibles;
                break;
            case 10:
                TakeID = Links.Transformers;
                break;
            case 11:
                TakeID=Links.CapA1;
                break;
            case 12:
                TakeID=Links.TOY;
                break;
            case 13:
                TakeID = Links.Avengers;
                break;
            case 14:
                TakeID=Links.Cars;
                break;
            case 15:
                TakeID=Links.Deadpool;
                break;
            case 16:
                TakeID = Links.TOY2;
                break;
            case 17:
                TakeID=Links.TOY3;
                break;
            case 18:
                TakeID=Links.Titanic;
                break;
            case 19:
                TakeID = Links.Avengers2;
                break;
            case 20:
                TakeID=Links.Avengers3;
                break;
            case 21:
                TakeID=Links.IT;
                break;
            case 22:
                TakeID = Links.CapA2;
                break;
            case 23:
                TakeID=Links.CapA3;
                break;
            case 24:
                TakeID=Links.TheIncredibles2;
                break;
        }
        MediaController mc = new MediaController(this);
        Video=(VideoView)findViewById(R.id.video);
        Uri uri = Uri.parse(TakeID);
        Video.setMediaController(mc);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Video.setVideoURI(uri);
        Video.requestFocus();
        Video.start();
        //hideSystemUI();




    }
    public void out(View v){
       this.finish();
    }

}
