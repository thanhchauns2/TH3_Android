package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText minPriceEditText;
    private EditText maxPriceEditText;
    private EditText areaEditText;
    private EditText cityEditText;
    private EditText electricityEditText;

    private Button searchButton;
    private Button deleteButton;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        minPriceEditText = findViewById(R.id.minPrice);
        maxPriceEditText = findViewById(R.id.maxPrice);
        areaEditText = findViewById(R.id.area);
        cityEditText = findViewById(R.id.city);
        electricityEditText = findViewById(R.id.electricity);

        searchButton = findViewById(R.id.search_button);
        deleteButton = findViewById(R.id.delete);
        addButton = findViewById(R.id.button6);

        // Set click listeners
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, Search.class);
                searchIntent.putExtra("minPriceEditText", minPriceEditText.getText());
                searchIntent.putExtra("maxPriceEditText", maxPriceEditText.getText());
                searchIntent.putExtra("areaEditText", areaEditText.getText());
                searchIntent.putExtra("cityEditText", cityEditText.getText());
                searchIntent.putExtra("electricityEditText", electricityEditText.getText());
                startActivity(searchIntent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete button click
            }
        });
    }
}

