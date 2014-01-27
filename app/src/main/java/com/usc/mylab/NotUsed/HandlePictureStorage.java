package com.usc.mylab.NotUsed;

import android.hardware.Camera.PictureCallback;
import android.hardware.Camera;



/**
 * Created by kanchanapratharasappan on 11/26/13.
 */
public class HandlePictureStorage implements PictureCallback
    {

        @Override
        public void onPictureTaken(byte[] picture, Camera camera)
        {
            //The picture can be stored or do something else with the data
            //in this callback such sharing with friends, upload to a Cloud component etc

            //This is invoked when picture is taken and the data needs to be processed
            System.out.println("Picture successfully taken: "+picture);




        }
    }

