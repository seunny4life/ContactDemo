package com.example.contactdemo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DataBase dataBase;
    private ContactAdapter contactAdapter;
    private RecyclerView recyclerView;
    private List<ContactsData> contactsDataList;
    private ImageButton deleteDemo, editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacts.class);
                startActivity(intent);
            }
        });
        fillData();

        // deleteNow();

    }

    public void fillData() {

        dataBase = new DataBase(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDisplay);

        contactsDataList = dataBase.showAllContact();

        contactAdapter = new ContactAdapter(this, contactsDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);



        recyclerView.setAdapter(contactAdapter);


        /* dataBase = new DataBase(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewDisplay);
        contactsDataList = dataBase.showAllContact();

        contactAdapter = new ContactAdapter(this, contactsDataList);

        recyclerView.setAdapter(contactAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        */
    }



   /*
        public void deleteNow () {


        deleteDemo = simpleList.findViewById(R.id.imageDelete);
        deleteDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
}
