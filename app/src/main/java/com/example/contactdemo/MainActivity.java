package com.example.contactdemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void fillData() {
        recyclerView = findViewById(R.id.recyclerView);
        contactsDataList = new ArrayList<>();

        dataBase = new DataBase(this);

        contactAdapter = new ContactAdapter(this, contactsDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        contactsDataList = dataBase.showAllContact();

        recyclerView.setAdapter(contactAdapter);
    }


    public void deleteNow() {


   /*
        deleteDemo = simpleList.findViewById(R.id.imageDelete);
        deleteDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }


}