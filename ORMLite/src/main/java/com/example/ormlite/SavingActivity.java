package com.example.ormlite;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import domain.Person;
import domain.PersonOL;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Save a Person and display it again
 */
public class SavingActivity extends OrmLiteBaseActivity<DatabaseHelper> {

	private final String TAG = getClass().getSimpleName();

	TextView message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "SavingActivity.onCreate()");
		setContentView(R.layout.activity_saving);
		message = (TextView) findViewById(R.id.saved);
		final Person p = (Person) getIntent().getSerializableExtra("person");

		// get our dao
		RuntimeExceptionDao<Person, Integer> sampleDao = 
			getHelper().getSimpleDataDao();

		// Save Person in database
		sampleDao.create(p);

		Log.d(TAG, "Created Person " + ((PersonOL)p).getId());

		Person p = sampleDao.find(p.id);

		message.setText("Saved Person " + p);
	}
}
