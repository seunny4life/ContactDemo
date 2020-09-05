package com.example.contactdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //
    private static final String DATABASE_NAME = "contacts.db";

    private SQLiteDatabase sqLiteDatabase;

    public DataBase(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating a Table
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ContactsData.CREATE_TABLE);
    }

    //Upgrading a Table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Dropping older Table
        db.execSQL(ContactsData.DROP_TABLE);

        //Creating Table again
        onCreate(db);
    }


    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    //Insert into the table
    public long insertDataBase(String firstName, String lastName, String phoneNumber, String email) {
        //get Writeable database as we want to write data
        sqLiteDatabase = this.getWritableDatabase();

        //Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        //id will automatically insert

        contentValues.put(ContactsData.COLUMN_FIRSTNAME, firstName);
        contentValues.put(ContactsData.COLUMN_LASTNAME, lastName);
        contentValues.put(ContactsData.COLUMN_PHONENUMBER, phoneNumber);
        contentValues.put(ContactsData.COLUMN_EMAIL, email);

        // Insert the new row, returning the primary key value of the new row
        long insertData = sqLiteDatabase.insert(ContactsData.TABLE_NAME, null, contentValues);

        //close db connection
        sqLiteDatabase.close();

        return insertData;
    }

    // Get User Details based on userId
    public ContactsData getContact(long inserted) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(ContactsData.TABLE_NAME,
                new String[]{ContactsData.COLUMN_ID, ContactsData.COLUMN_FIRSTNAME,
                        ContactsData.COLUMN_LASTNAME, ContactsData.COLUMN_PHONENUMBER,
                        ContactsData.COLUMN_EMAIL},
                ContactsData.COLUMN_ID + "=?",
                new String[]{String.valueOf(inserted)},
                null, null, null, null);


        if (cursor != null)
            cursor.moveToFirst();


        ContactsData contactsData = new ContactsData(
                cursor.getInt(cursor.getColumnIndex(ContactsData.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_FIRSTNAME)),
                cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_LASTNAME)),
                cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_PHONENUMBER)),
                cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_EMAIL))
        );

        cursor.close();

        return contactsData;


    }

    // Get User Details

    public List<ContactsData> showAllContact() {

        sqLiteDatabase = this.getWritableDatabase();

        List<ContactsData> contactsData = new ArrayList<>();

        //SElect from all query
        String selectAllQuery = " SELECT * FROM " + ContactsData.TABLE_NAME
                + " ORDER BY " + ContactsData.COLUMN_FIRSTNAME;

        Cursor cursor = sqLiteDatabase.rawQuery(selectAllQuery, null);


        if (cursor.moveToFirst()) {
            do {
                ContactsData contactsData1 = new ContactsData();
                contactsData1.setId(cursor.getInt(cursor.getColumnIndex(ContactsData.COLUMN_ID)));
                contactsData1.setFirstName(cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_FIRSTNAME)));
                contactsData1.setLastName(cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_LASTNAME)));
                contactsData1.setPhoneNumber(cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_PHONENUMBER)));
                contactsData1.setEmail(cursor.getString(cursor.getColumnIndex(ContactsData.COLUMN_EMAIL)));
                contactsData.add(contactsData1);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();

        return contactsData;


    }

    //Delete
    public long deleteDemo(long nameId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long delete = sqLiteDatabase.delete(ContactsData.TABLE_NAME,
                ContactsData.COLUMN_ID + "=?",
                new String[]{String.valueOf(nameId)});

        sqLiteDatabase.close();

        return delete;
    }


}
