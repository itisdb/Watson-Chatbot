package com.example.vmac.WatBot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    //timer
    private static int SPLASH_TIME_OUT =4000;

    //variables for animation
    Animation topAnim, bottomAnim, rotate,rotate2;
    ImageView image;
    TextView logo,slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen code
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //loading the content layout
        setContentView(R.layout.splash);

        //Animation loading
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //rotate=AnimationUtils.loadAnimation(this, R.anim.rotate);
        //rotate2=AnimationUtils.loadAnimation(this, R.anim.rotate2);

        //hooks
        image=findViewById(R.id.splash_logo);
        logo=findViewById(R.id.monica2);
        //slogan=findViewById(R.id.tag);

        //animation initiation
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        //image.setAnimation(rotate);
        //image.setAnimation(rotate2);
        //image.setAnimation(rotate);
        //image.setAnimation(rotate2);
        //slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //this method will execute only once the timer is over
                //starting the main activity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                //close the activity
                finish();

            }
        },SPLASH_TIME_OUT);

    }
}



/**for no spash screen
public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);//used to start the mainactivity

        finish();
    }
}**/
