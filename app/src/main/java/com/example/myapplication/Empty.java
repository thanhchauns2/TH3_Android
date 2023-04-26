package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Empty extends AppCompatActivity {

    EditText id;

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        HouseDatabaseHelper db = new HouseDatabaseHelper(this);

        id = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.button3);

        // TODO: Thêm xử lý cho button2 khi người dùng click vào đó
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long houseId = Long.parseLong(id.getText().toString());

                House house = new House(houseId, -1, -1, -1, -1, "1");
                Intent back = new Intent(Empty.this, MainActivity.class);
                db.deleteHouse(house);
                startActivity(back);
                // TODO: Gửi object House này đến một đối tượng khác để lưu trữ hoặc xử lý dữ liệu.
            }
        });
    }
}