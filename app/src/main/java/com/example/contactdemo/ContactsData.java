package com.example.contactdemo;

public class ContactsData {


    //Creating my Table Here
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_EMAIL = "email";


    //Set my information to private
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


    //CREATE A TABLE SQL QUERY
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRSTNAME + " TEXT NOT NULL, "
            + COLUMN_LASTNAME + " TEXT, "
            + COLUMN_PHONENUMBER + " TEXT NOT NULL, "
            + COLUMN_EMAIL + " TEXT"
            + ")";


    //CHECKING MAYBE IS EXISTING
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public ContactsData() {
    }


    public ContactsData(int id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
