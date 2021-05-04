package com.and.sparkbankingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 + " (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(8102223631,'Aman Ahuja',98563,'amanahuja0657@gmail.com','5100XXXXXXXX6215','HDFC0005435')");
        db.execSQL("insert into user_table values(7004888268,'Akashdeep',52100,'rahisinha21@gmail.com','4325XXXXXXXX21674','SBIN0005432')");
        db.execSQL("insert into user_table values(9955443322,'Neha Mandal',95364,'nehamandal1505@gmail.com','3465XXXXXXXX2168','ALBH0005321')");
        db.execSQL("insert into user_table values(9102236482,'Shreya Tiwary',80521,'shreyakumari@gmail.com','3125XXXXXXXX2136','BOIN0003512')");
        db.execSQL("insert into user_table values(6204589234,'Sumit Sharma',62516,'1998sumit@gmail.com','3125XXXXXXXX2675','SBIN0009547')");
        db.execSQL("insert into user_table values(7260452188,'Raman Singh Gumtala',35694,'Singh1998@gmail.com','4256XXXXXXXX1673','HDFC0001098')");
        db.execSQL("insert into user_table values(8563201478,'Avinash Kumar',26394,'avinash.kumar@gmail.com','4165XXXXXXXX6713','SBIN0006578')");
        db.execSQL("insert into user_table values(8760325941,'Akanksha Pandey',48500,'akpandey@gmail.com','5210XXXXXXXX9436','HDFC0009642')");
        db.execSQL("insert into user_table values(7808427569,'Samrat Mukherjee',16452,'samrat.mukherjee16@gmail.com','5100XXXXXXXX1367','SBIN0002176')");
        db.execSQL("insert into user_table values(8602223176,'Aman Gupta',52130,'guptatraders@gmail.com','3700XXXXXXXX3492','BOIN0003672')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " + phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " + phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " + phonenumber);
    }

    public Cursor readtransferdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date, String from_name, String to_name, String amount, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}