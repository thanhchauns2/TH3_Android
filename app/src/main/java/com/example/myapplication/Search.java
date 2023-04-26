package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        HouseDatabaseHelper helper = new HouseDatabaseHelper(this);
        List<House> houseList = helper.getAllHouses();

        lv = findViewById(R.id.lv);;

        String minPriceEditText = getIntent().getStringExtra("minPriceEditText");
        String maxPriceEditText = getIntent().getStringExtra("maxPriceEditText");
        String areaEditText = getIntent().getStringExtra("areaEditText");
        String cityEditText = getIntent().getStringExtra("cityEditText");
        String electricityEditText = getIntent().getStringExtra("electricityEditText");

        List<House> satisfied = new ArrayList<House>();

        int min_p = 0, max_p = 1000000000;
        int area = -1;
        String city = "-1";
        int electricity = -1;
        if (minPriceEditText != null){
            min_p = Integer.parseInt(minPriceEditText);
        }
        if (maxPriceEditText != null){
            max_p = Integer.parseInt(maxPriceEditText);
        }
        if (areaEditText != null){
            area = Integer.parseInt(areaEditText);
        }
        if (electricityEditText != null){
            electricity = Integer.parseInt(electricityEditText);
        }
        for (House h : houseList){
//            System.out.println(h);
//            if (h.getRentPrice() < min_p || h.getRentPrice() > max_p) continue;
//            if (h.getArea() != -1 && h.getArea() != area) continue;
//            if (h.getElectricityPrice() != -1 && h.getElectricityPrice() != electricity) continue;
//            if (h.getAreaCode() != "-1" && h.getAreaCode() != city) continue;
            satisfied.add(h);
        }
        for (House h : satisfied){
            System.out.println(h);
        }
        ArrayAdapter<House> adapter = new ArrayAdapter<House>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, satisfied);
        lv.setAdapter(adapter);
    }
}