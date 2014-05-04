public class ContentValuesDemos {

	public void insertDemo() {
		ContentValues cv = new ContentValues();
		cv.put("firstName", "Ian");
		cv.put("lastName", "Darwin");
		cv.put("occupation", "Androidist");
		long newId = db.insert(cv);
		Log.d(TAG, "Inserted Person record # " + newId);
	}
}
