package com.example.templatereceiver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import domain.Person;

public class SavingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saving);
		
		Person p = (Person) getIntent().getSerializableExtra("person");
		
		// Write some code here to:                        XXX DELETE THIS LINE WHEN DONE
		// Save the Person (which might be a Customer!)
		// If that doen't throw an exception, the code below will report success
		
		TextView message = (TextView) findViewById(R.id.saved);
		String format = getString(R.string.saved);
		String toDisplay = String.format(format, p);
		message.setText(toDisplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saving, menu);
		return true;
	}

}
