package com.usc.mylab.Profile;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.app.R;

public class EditTestResultsActivity extends Activity {
	
	private int year;
	private int month;
	private int day;
	TextView date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_result);
		
		Button next = (Button) findViewById(R.id.btnEditTestResult);
	    next.setOnClickListener(new OnClickListener() {
	        public void onClick(View view) {
	        	int requestCode = 0;
	        	//Intent myIntent = new Intent(view.getContext(), editTestResultsActivity.class);
	            //startActivity(myIntent);
	        }

	    });
	    
	   
	    date = (TextView) findViewById(R.id.date);
		date.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				showDialog(999);
 
			}
 
		});
		
		
	}
	
	//public void onClick(View v){
		
		//TextView date = (TextView) findViewById(R.id.date);
		//date.setText("here");
		//v.showDialog(999);
	//}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 999:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, 
                         year, month,day);
		}
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener datePickerListener 
    	= new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
			int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
				
				date.setText("text");
				
				/*// set selected date into textview
				tvDisplayDate.setText(new StringBuilder().append(month + 1)
				   .append("-").append(day).append("-").append(year)
				   .append(" "));
				
				// set selected date into datepicker also
				dpResult.init(year, month, day, null);*/

		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
