package com.usc.mylab.Profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.app.R;

public class AddTestResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		Button next = (Button) findViewById(R.id.btnAddTestResult);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), AddTestResultActivity.class);
	            startActivity(myIntent);
	        }

	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
