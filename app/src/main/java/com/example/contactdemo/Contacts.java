package com.example.contactdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contacts extends AppCompatActivity {

    private EditText firstName, lastName, phoneNumber, email;
    private Button cancel, addContact;
    private Intent intent;
    private ContactsData contactsData;
    private ContactAdapter contactAdapter;
    private DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        saveData();
    }

    public void saveData() {
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
        cancel = findViewById(R.id.cancelBtn);
        addContact = findViewById(R.id.addBtn);
        cancelBtn();
        addInformation();
    }

//Return to front page
    public void cancelBtn() {
        intent = new Intent(getApplicationContext(), MainActivity.class);
        cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT)
                                .show();
                        startActivity(intent);
                    }
                }
        );
    }

    //Add information to database
    public void addInformation() {


        intent = new Intent(getApplicationContext(), MainActivity.class);
        dataBase = new DataBase(Contacts.this);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fName = firstName.getText().toString().trim();
                final String lName = lastName.getText().toString().trim();
                final String phone = phoneNumber.getText().toString().trim();
                final String eMail = email.getText().toString().trim();
                final String details = String.format("%s\n%s\n%s\n%s", fName, lName, phone, eMail).trim();

                if (fName.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Name and Phone Number",
                            Toast.LENGTH_SHORT).show();

                } else {
                    dataBase.insertDataBase(fName, lName, phone, eMail);
                    finish();
                    Toast.makeText(getApplicationContext(), details, Toast.LENGTH_SHORT)
                            .show();

                }
            }
        });

    }
}