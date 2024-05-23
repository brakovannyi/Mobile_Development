package ru.mirea.suetinan.inventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = findViewById(R.id.textView);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        tv.setText("Квадрат значения моего номера по списку в группе составляет " + Math.pow(29, 2) + ", а текущее время " + date);
    }
}
