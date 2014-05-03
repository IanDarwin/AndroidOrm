package com.example.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import domain.Person;

public class SavingActivity extends Activity {
	
	private static final String TABLE_NAME = "person";

	TextView message;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saving);
		message = (TextView) findViewById(R.id.saved);
		final Person p = (Person) getIntent().getSerializableExtra("person");
		db = new MySqliteHelper(this, "sqlite-demo").getWritableDatabase();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				// Save the Person (which might be a Customer subclass, and might have an Address!)
				ContentValues cv = new ContentValues();
				cv.put("firstname", p.getFirstName());
				cv.put("lastName", p.getLastName());
				cv.put("street", p.getAddress().getCity());
				cv.put("city", p.getAddress().getCity());
				
				long id = db.insertOrThrow("person", null, cv);
				p.setId(id);
				
				String format = getString(R.string.saved);
				final String toDisplay = String.format(format, p);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						message.setText(toDisplay);
					}
				});
			}}).start();		
	}

	class MySqliteHelper extends SQLiteOpenHelper {

		public MySqliteHelper(Context context, String name) {
			super(context, name, null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table " + TABLE_NAME + " (_id integer primary key, " +
					"firstname varchar, lastname varchar, street varchar, city varchar)"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			throw new IllegalArgumentException("No upgrade");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.saving, menu);
		return true;
	}

}
