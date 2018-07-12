package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecondActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_layout);

        EditText mdate = findViewById(R.id.edit_date);
        Date dNow = new Date();
        SimpleDateFormat fd =
                new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        String date = fd.format(dNow);
        String time = ft.format(dNow);
        mdate.setText(date);
        mdate.setEnabled(false);
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Item 1");
        categories.add("Item 2");
        categories.add("Item 3");
        categories.add("Item 4");
        categories.add("Item 5");
        categories.add("Item 6");

        String[] ser = {"asdf","asdf","ager","sdf"};

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ser);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}