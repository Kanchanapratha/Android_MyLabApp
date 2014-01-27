package com.usc.mylab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.sql.*;
import java.util.Date;
import com.example.app.R;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.widget.*;
import com.usc.mylab.handlers.DatabaseHandler;
import com.usc.mylab.helpers.Contact;

import com.usc.mylab.util.SystemUiHider;



/**
 * Created by kanchanapratharasappan on 11/25/13.
 */
public class myLab_AddContact extends Activity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link com.usc.mylab.util.SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link com.usc.mylab.util.SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    ImageView image;
    byte[] picture;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_lab_addcontact);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);



        image = (ImageView)findViewById(R.id.imageView);

        ImageButton takeAPicture = (ImageButton)findViewById(R.id.imageButton);
        takeAPicture.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Intent goToNextActivity = new Intent(getApplicationContext(), myLab_ImagePreview.class );
                startActivityForResult(goToNextActivity, 1);
            }
        });

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TextView name = (TextView) findViewById(R.id.name);
                String sname = name.getText().toString();
                TextView phone = (TextView) findViewById(R.id.phone);
                String sphone = phone.getText().toString();
                TextView email = (TextView) findViewById(R.id.email);
                String semail = email.getText().toString();
                TextView other = (TextView) findViewById(R.id.other);
                String sother = other.getText().toString();
                String sdate = new Timestamp(new Date().getTime()).toString();
                DatabaseHandler db = new DatabaseHandler(myLab_AddContact.this);
                db.addContact(new Contact(sname,sphone,semail,sother,sdate,myLab_AddContact.this.picture));
                Toast.makeText(getApplicationContext(),"Prospect added Successfully", 10000);
                System.out.print("Data inserted Successfully");
                finish();
                Intent goToNextActivity = new Intent(getApplicationContext(), myLabProfile.class );
                startActivity(goToNextActivity);

            }
        });



        // this activity.
        mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
        mSystemUiHider.setup();
        mSystemUiHider
                .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
                    // Cached values.
                    int mControlsHeight;
                    int mShortAnimTime;

                    @Override
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
                    public void onVisibilityChange(boolean visible) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                            // If the ViewPropertyAnimator API is available
                            // (Honeycomb MR2 and later), use it to animate the
                            // in-layout UI controls at the bottom of the
                            // screen.
                            if (mControlsHeight == 0) {
                                mControlsHeight = controlsView.getHeight();
                            }
                            if (mShortAnimTime == 0) {
                                mShortAnimTime = getResources().getInteger(
                                        android.R.integer.config_shortAnimTime);
                            }
                            controlsView.animate()
                                    .translationY(visible ? 0 : mControlsHeight)
                                    .setDuration(mShortAnimTime);
                        } else {
                            // If the ViewPropertyAnimator APIs aren't
                            // available, simply show or hide the in-layout UI
                            // controls.
                            controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                        }

                        if (visible && AUTO_HIDE) {
                            // Schedule a hide().
                            delayedHide(AUTO_HIDE_DELAY_MILLIS);
                        }
                    }
                });


    // Set up the user interaction to manually show or hide the system UI.
    contentView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (TOGGLE_ON_CLICK) {
                mSystemUiHider.toggle();
            } else {
                mSystemUiHider.show();
            }
        }
    });


    // Upon interacting with UI controls, delay any scheduled hide()
    // operations to prevent the jarring behavior of controls going away
    // while interacting with the UI.
    //findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
}


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


/**
 * Touch listener to use for in-layout UI controls to delay hiding the
 * system UI. This is to prevent the jarring behavior of controls going away
 * while interacting with activity UI.
 */
View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (AUTO_HIDE) {
            delayedHide(AUTO_HIDE_DELAY_MILLIS);
        }
        return false;
    }
};

Handler mHideHandler = new Handler();
Runnable mHideRunnable = new Runnable() {
    @Override
    public void run() {
        mSystemUiHider.hide();
    }
};

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try
        {
        if(requestCode == 1 && resultCode == RESULT_OK)
        {/*
            Uri uri = data.getData();
            InputStream iStream =   getContentResolver().openInputStream(uri);
            byte[] inputData;
            inputData = getBytes(iStream);*/
        this.picture = data.getByteArrayExtra("picture");
        Bitmap bitmap = BitmapFactory.decodeByteArray(this.picture, 0, this.picture.length);

       // Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
       // BitmapShader shader = new BitmapShader (bitmap,  TileMode.CLAMP, TileMode.CLAMP);
        //Paint paint = new Paint();
       // paint.setShader(shader);
       // Canvas c = new Canvas(circleBitmap);
       // c.drawCircle(bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), paint);
       //image = (ImageView)myLab_AddContact.this.findViewById(R.id.image);
        image.setImageBitmap(bitmap);
            image.setRotation(90);
        }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

    }

}

