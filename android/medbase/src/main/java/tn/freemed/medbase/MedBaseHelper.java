package tn.freemed.medbase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import android.util.Log;

class MedBaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "medbase.db";
	private static final int SCHEMA_VERSION=1;

	public SQLiteDatabase dbSqlite;

	private final Context myContext;
	private final String DATABASE_PATH;

	public MedBaseHelper(Context context){
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
		this.myContext = context;
		this.DATABASE_PATH = context.getApplicationInfo().dataDir +	"/databases/";
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void createDatabase() {
		createDB();
	}

	private void createDB() {
		boolean dbExist = DBExists();
		if (!dbExist) {
			this.getReadableDatabase();
			copyDBFromResource();
		}
	}

	private boolean DBExists() {

		SQLiteDatabase db = null;
		try {
			String databasePath = DATABASE_PATH + DATABASE_NAME;
			db = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
			db.setLocale(Locale.getDefault());
			db.setVersion(1);
		} catch (SQLiteException e) {
			Log.e("SqlHelper", "La base de données des médicaments n'a pas été trouvée.");
		}

		if (db != null) {
			db.close();
		}
		return db != null ? true : false;

	}

	private void copyDBFromResource() {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		String dbFilePath = DATABASE_PATH + DATABASE_NAME;

		try {

			inputStream = myContext.getAssets().open(DATABASE_NAME);
			outputStream = new FileOutputStream(dbFilePath);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();

		} catch (IOException e) {
			throw new Error("Problème lors de la copie de la base de données des médicaments.");
		}

	}
	@Override

	public synchronized void close() {
		if (dbSqlite != null) {
			dbSqlite.close();
		}
		super.close();
	}

}