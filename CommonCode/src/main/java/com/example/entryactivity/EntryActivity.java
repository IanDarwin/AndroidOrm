package com.example.entryactivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import domain.Address;
import domain.Person;
import domain.pojo.AddressPojo;
import domain.pojo.PersonPojo;

public class EntryActivity extends Activity {
	
	private static final String TAG = EntryActivity.class.getSimpleName();
	
	EditText mFirstName, mLastName, mStreet, mCity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "EntryActivity.onCreate()");
		setContentView(R.layout.activity_entry);
		mFirstName = (EditText) findViewById(R.id.etFirstName);
		mLastName =(EditText) findViewById(R.id.etLastName);
		mStreet = (EditText) findViewById(R.id.etstreet);
		mCity = (EditText) findViewById(R.id.etcity);
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
		String mainClazzName = null, 
			personClazzName = null, 
			addressClazzName = null;
		try {
			// Find the class to invoke
			final String PROPS_NAME = "/androidorm.properties";
			InputStream is = getClass().getResourceAsStream(PROPS_NAME);
			if (is == null) {
				die("Project does not include androidorm.properties");
			}
			Properties pr = new Properties();
			pr.load(is);
			mainClazzName = pr.getProperty("mainActivity");
			if (mainClazzName == null) {
				die("mainActivity not set in " + PROPS_NAME);
			}
			personClazzName = pr.getProperty("personClass", "domain.pojo.PersonPojo");
			personClazzName = pr.getProperty("addressClass", "domain.pojo.AddressPojo");
			is.close();
		} catch (IOException e) {
			die("IO Error trying to read androidorm.properties", e);
		}
		Person p = null;
		Address address = null;
		try {
			p = (Person) Class.forName(personClazzName).newInstance();
			address = (Address)Class.forName(addressClazzName).newInstance();
		} catch (Exception e) {
			die("Exception in loading Person and Address", e);
		}
		p.setFirstName(mFirstName.getText().toString());
		p.setLastName(mLastName.getText().toString());
		
		String street = mStreet.getText().toString();
		String city = mCity.getText().toString();
		if (street != null || city != null) {
			address.setStreetAddress(street);
			address.setCity(city);
			p.setAddress(address);
		}
		// XXX more
		
		try {	
			// And pass the filled-in Person to the save handler
			Intent intent = new Intent(this, Class.forName(mainClazzName));
			intent.putExtra("person", (Serializable)p);
			startActivity(intent);
		} catch (Exception e) {
			die("Caught exception starting intent", e);

		}
	}

	private void die(String msg, Exception e) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		Log.wtf(TAG, msg, e);
		new Thread(new Runnable() {
			public void run() {
				SystemClock.sleep(1000);
				}
		}).start();
		System.exit(1);
	}
	
	private void die(String msg) {
		die(msg, null);
	}

}
