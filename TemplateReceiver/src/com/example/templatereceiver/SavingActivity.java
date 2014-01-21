package com.example.templatereceiver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.entryactivity.EntryActivity;

public class SavingActivity extends Activity {

	@SuppressWarnings("unused")// Needed to force loading of this class
	private EntryActivity activity = new EntryActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saving);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saving, menu);
		return true;
	}

}
