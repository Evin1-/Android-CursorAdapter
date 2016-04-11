package com.example.sqlitecursoradapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by evin on 4/11/16.
 */
public class UsersDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usersDB";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_USERS = "users";

    public static final String KEY_USER_ID = "_id";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_AGE = "age";

    public UsersDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +
                "(" +
                KEY_USER_ID + " INTEGER PRIMARY KEY," +
                KEY_USER_NAME + " TEXT," +
                KEY_AGE + " TEXT" +
                ")";

        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}