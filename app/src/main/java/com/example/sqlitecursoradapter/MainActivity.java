package com.example.sqlitecursoradapter;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private static final String EXAMPLE_NAME = "Edwin";
    private static final int EXAMPLE_AGE = 64;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fillDatabase(View view) {
        UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = usersDatabaseHelper.getWritableDatabase();

        db.beginTransaction();
        try {
            for (int i = 0; i < 10; i++) {
                ContentValues values = new ContentValues();
                values.put(UsersDatabaseHelper.KEY_USER_NAME, EXAMPLE_NAME + " " + i);
                values.put(UsersDatabaseHelper.KEY_AGE, EXAMPLE_AGE + i);

                db.insertOrThrow(UsersDatabaseHelper.TABLE_USERS, null, values);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    public void loadInformation(View view) {

    }
}
