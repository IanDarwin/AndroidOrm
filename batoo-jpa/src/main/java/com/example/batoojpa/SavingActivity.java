package com.example.batoojpa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import domain.Person;
import domain.jpa.PersonJPA;

public class SavingActivity extends Activity {
	final static String TAG = SavingActivity.class.getName();
	TextView message;
	JpaDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "SavingActivity.onCreate()");
		setContentView(R.layout.activity_saving);
		message = (TextView) findViewById(R.id.saved);
		final Person p = (Person) getIntent().getSerializableExtra("person");
		dao = new JpaDao();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				// Save the Person (which might be a Customer subclass, and might have an Address!)
				dao.savePerson(p);
				
				// Fetch this copy of "p" back from the database.
				Person q = dao.getPersonById(((PersonJPA) p).getId());
				
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
