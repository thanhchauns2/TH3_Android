package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class Add extends AppCompatActivity {

    private EditText id;
    private EditText area;
    private EditText price;
    private EditText electric;
    private EditText water;
    private EditText city;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        HouseDatabaseHelper db = new HouseDatabaseHelper(this);

        id = findViewById(R.id.editTextTextPersonName6);
        area = findViewById(R.id.editTextTextPersonName7);
        price = findViewById(R.id.editTextTextPersonName8);
        electric = findViewById(R.id.editTextTextPersonName9);
        water = findViewById(R.id.editTextTextPersonName10);
        city = findViewById(R.id.editTextTextPersonName11);
        submit = findViewById(R.id.button2);

        // TODO: Thêm xử lý cho button2 khi người dùng click vào đó
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long houseId = Long.parseLong(id.getText().toString());
                double houseArea = Double.parseDouble(area.getText().toString());
                double houseRentPrice = Double.parseDouble(price.getText().toString());
                double houseElectricityPrice = Double.parseDouble(electric.getText().toString());
                double houseWaterPrice = Double.parseDouble(water.getText().toString());
                String houseAreaCode = city.getText().toString();

                House house = new House(houseId, houseArea, houseRentPrice, houseElectricityPrice, houseWaterPrice, houseAreaCode);
                Intent back = new Intent(Add.this, MainActivity.class);
                db.addHouse(house);
                startActivity(back);
                // TODO: Gửi object House này đến một đối tượng khác để lưu trữ hoặc xử lý dữ liệu.
            }
        });

    }
}
