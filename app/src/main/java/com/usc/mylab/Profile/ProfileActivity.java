package com.usc.mylab.Profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.app.R;


public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		//TextView tvTextView = (TextView) findViewById(R.id.textView1);
		//Typeface typeface = Typeface.createFromAsset(getAssets(),"Roboto-Regular.TTF");
		//tvTextView.setTypeface(typeface);
		
		ImageView next = (ImageView) findViewById(R.id.btnImageView11);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	Intent myIntent = new Intent(view.getContext(), EditTestResultsActivity.class);
	            startActivity(myIntent);
	        }

	    });
	    
		//ImageView image = (ImageView) findViewById(R.id.imageView1);
		
		/*SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.photoplaceholder);
		// Get a drawable from the parsed SVG and set it as the drawable for the ImageView
		image.setImageDrawable(svg.createPictureDrawable());
		
		
	    ImageButton imageButton = (ImageButton) findViewById(R.id.btnClamydia);
	    
		imageButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			   //Toast.makeText(ProfileActivity.this,
				//"ImageButton is clicked!", Toast.LENGTH_SHORT).show();
				Intent myIntent = new Intent(arg0.getContext(), EditTestResultsActivity.class);
	            startActivity(myIntent);
 
			}
 
		});
	    
	    ImageButton imageButton1 = (ImageButton) findViewById(R.id.btnGonorrea);*/
	    
		/*imageButton.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			   Toast.makeText(ProfileActivity.this,
				"ImageButton is clicked!", Toast.LENGTH_SHORT).show();
 
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
