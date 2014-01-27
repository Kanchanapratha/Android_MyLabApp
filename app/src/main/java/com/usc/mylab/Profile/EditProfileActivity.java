package com.usc.mylab.Profile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.app.R;

public class EditProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		
		/*Button next = (Button) findViewById(R.id.btnChlamydiaResult);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), editTestResultsActivity.class);
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
