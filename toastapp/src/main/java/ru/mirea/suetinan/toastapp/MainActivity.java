package ru.mirea.suetinan.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickToast(View view){
        Edit = findViewById(R.id.editTextText);
        int count = Edit.getText().length();
        Toast toast = Toast.makeText(getApplicationContext(),
                "СТУДЕНТ №29 ГРУППА БСБО-06-22 Количество символов - " + Integer.toString(count),
                Toast.LENGTH_SHORT);
        toast.show();
    }
}