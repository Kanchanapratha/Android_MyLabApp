package com.usc.mylab;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Button;

import com.example.app.R;
import com.usc.mylab.util.CameraSurfaceView;
import android.hardware.Camera.PictureCallback;


/**
 * Created by kanchanapratharasappan on 11/26/13.
 */
public class myLab_ImagePreview extends Activity implements PictureCallback{

    public byte[] loverPic;

    @Override
    public void onPictureTaken(byte[] picture, Camera camera)
    {
        //The picture can be stored or do something else with the data
        //in this callback such sharing with friends, upload to a Cloud component etc

        //This is invoked when picture is taken and the data needs to be processed
        System.out.println("Picture successfully taken: "+picture);
        Intent acti = myLab_ImagePreview.this.getIntent();
        acti.putExtra("picture",picture);
        myLab_ImagePreview.this.setResult(RESULT_OK,acti);
        myLab_ImagePreview.this.finish();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_lab_camera);


        final CameraSurfaceView cameraSurfaceView = new CameraSurfaceView(this);
        FrameLayout preview = (FrameLayout)findViewById(R.id.preview);
        preview.addView(cameraSurfaceView);


        Button takeAPicture = (Button)findViewById(R.id.takepic);
        takeAPicture.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Camera camera = cameraSurfaceView.getCamera();
                camera.takePicture(null, null,myLab_ImagePreview.this);

            }
        });
}
}
