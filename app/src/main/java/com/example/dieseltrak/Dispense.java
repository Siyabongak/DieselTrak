package com.example.dieseltrak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dispense extends AppCompatActivity {
    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispense);
        tvRes = findViewById(R.id.tvRes);
        String name = getIntent().getStringExtra("data");
        tvRes.setText(name);
    }
}