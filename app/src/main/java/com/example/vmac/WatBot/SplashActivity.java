package com.example.vmac.WatBot;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**public class SplashActivity extends AppCompatActivity {

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
}**/



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


public class SplashActivity extends AppCompatActivity {


    //progress bar variable
    private ProgressBar progressBar;


    TextView textView,textView1;
    ImageView imageView;
    Animation animationUptoDown , animationDownToUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //for background animation
        RelativeLayout relativeLayout=findViewById(R.id.splashanim);
        AnimationDrawable animationDrawable=(AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        textView = findViewById(R.id.txt_v);
        textView1=findViewById(R.id.textView);
        imageView = findViewById(R.id.image_view);
        init();
        animationUptoDown = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.uptodownanim);
        animationDownToUp = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.downtotopanim);

        imageView.setAnimation(animationUptoDown);
        textView.setAnimation(animationDownToUp);
        progressBar.setAnimation(animationDownToUp);
        textView1.setAnimation(animationDownToUp);


        //progress bar action
        progressBar.setVisibility(View.VISIBLE);
        textView1.setVisibility(View.VISIBLE);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //progress bar action stops
                progressBar.setVisibility(View.GONE);

                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        },10000);
    }
    private void init(){
        this.progressBar=findViewById(R.id.progressBar2);
    }
}
