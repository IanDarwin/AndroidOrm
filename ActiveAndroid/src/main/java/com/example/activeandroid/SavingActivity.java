package com.example.activeandroid;

import com.activeandroid.query.Select;
import com.example.activeandroid.SavingActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import domain.Person;
import domain.activeandroid.PersonAA;

public class SavingActivity extends Activity {
	final static String TAG = SavingActivity.class.getName();
	
	TextView message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "SavingActivity.onCreate()");
		setContentView(R.layout.activity_saving);
		message = (TextView) findViewById(R.id.saved);
		final Person p = (Person) getIntent().getSerializableExtra("person");
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				// Save the Person (which might be a Customer subclass, and might have an Address!)
				((PersonAA) p).save();
				
				// Fetch this copy of "p" back from the database.
				// XXX get by id as this only works sometimes based onorder
				Person q = (Person)new Select().from(PersonAA.class).orderBy("firstName").executeSingle();
				
				String format = getString(R.string.saved);
				final String toDisplay = String.format(format, q);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						message.setText(toDisplay);
					}
				});
			}}).start();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saving, menu);
		return true;
	}

}
