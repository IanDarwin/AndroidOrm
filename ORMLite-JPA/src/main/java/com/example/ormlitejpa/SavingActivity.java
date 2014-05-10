package com.example.ormlitejpa;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import domain.Person;
import domain.jpa.PersonJPA;

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
		final PersonJPA p = (PersonJPA) getIntent().getSerializableExtra("person");

		// get our dao
		RuntimeExceptionDao<PersonJPA, Integer> sampleDao = getHelper().getPersonDao();

		// Save Person in database
		sampleDao.create(p);

		Log.d(TAG, "Created Person " + ((PersonJPA)p).getId());

		PersonJPA p2 = sampleDao.queryForId((int)((PersonJPA) p).getId());

		message.setText("Saved Person " + p2);
	}
}
