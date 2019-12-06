package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_SNAME = "sname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = " create table contacts ( id integer primary key not null , " +
            " fname text not null, sname text not null, email text not null, uname text not null, password text not null ); " ;
    private Object ContentValues;


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = " DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String QUERY = "select * from contacts";
        Cursor cursor = db.rawQuery(QUERY, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_FNAME, c.getFname());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_SNAME, c.getSname());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchpass(String username)
    {
        db = this.getReadableDatabase();
        String Query = " select uname ,password from contacts ";
        Cursor cursor = db.rawQuery(Query, null);
        String a,b;
        b = "NOT FOUND";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                if(a.equals(username))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

}
