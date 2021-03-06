package com.appank.fromlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2="username";
    public static final String COL_3="password";
    public static final String COL_4="password";



    public DatabaseHelper(Context context){
        super ( context,DATABASE_NAME, null, 1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_2 + " TEXT, " + COL_3 + " TEXT)";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        //   sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public long tambahUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return  res;
    }
    public boolean periksaUser(String username, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " AND " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
    public boolean delet(String username, String password){
        //String[] columns = { COL_1 };
        SQLiteDatabase dba = getReadableDatabase();
        String selection = COL_2 + "=?" + " AND " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        // DBMahasiswa getDatabase = new DBMahasiswa(view.getContext());
        // SQLiteDatabase DeleteData = getDatabase.getWritableDatabase();
        dba.delete(TABLE_NAME, selection, selectionArgs);
        return false;
    }

}