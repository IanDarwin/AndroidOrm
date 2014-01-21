package com.example.entryactivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import domain.Person;

public class EntryActivity extends Activity {
	
	private static final String TAG = EntryActivity.class.getSimpleName();
	
	EditText mFirstName, mLastName;
	// XXX more

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		mFirstName = (EditText) findViewById(R.id.etFirstName);
		mLastName =(EditText) findViewById(R.id.etLastName);
		// XXX more
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entry, menu);
		return true;
	}
	
	public void register(View v) {
		Log.d(TAG, "EntryActivity.register");
		Person p = new Person();
		p.setFirstName(mFirstName.getText().toString());
		p.setLastName(mLastName.getText().toString());
		// XXX more
		
		try {
			// Find the class to invoke
			InputStream is = getClass().getResourceAsStream("/androidorm.properties");
			if (is == null) {
				String msg = "Project does not include androidorm.properties";
				Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
				Log.wtf(TAG, msg);
				System.exit(1);
			}
			Properties pr = new Properties();
			pr.load(is);
			String clazzName = pr.getProperty("mainActivity");
			
			// And pass the filled-in Person to the save handler
			Intent intent = new Intent(this, Class.forName(clazzName));
			intent.putExtra("person", p);
			LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
		} catch (Exception e) {
			String msg = "Caught exception " + e;
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
			Log.wtf(TAG, msg);
			System.exit(1);
		}
	}

}
