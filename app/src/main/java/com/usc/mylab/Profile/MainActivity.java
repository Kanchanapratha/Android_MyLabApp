package com.usc.mylab.Profile;

//import com.sportsbuysell.R;
//import com.sportsbuysell.;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.app.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button next = (Button) findViewById(R.id.btnProfile);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), ProfileActivity.class);
	            startActivity(myIntent);
	        }

	    });
	    
	    Button next1 = (Button) findViewById(R.id.btnEditProfile);
	    next1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), EditProfileActivity.class);
	            startActivity(myIntent);
	        }

	    });
	    
	    /*Button next2 = (Button) findViewById(R.id.btnCustomAdapter);
	    next1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), StoryReportsActivity1.class);
	            startActivity(myIntent);
	        }

	    });*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
