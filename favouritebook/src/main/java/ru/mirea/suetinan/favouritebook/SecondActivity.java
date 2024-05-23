package ru.mirea.suetinan.favouritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            TextView TextViewDeveloperBook = findViewById(R.id.textViewDeveloperBook);
            String developerBook = extras.getString(MainActivity.KEY);
            TextViewDeveloperBook.setText(String.format("Любимая книга разработчика - %s", developerBook));
        }
    }

    public void SendBookData(View view){
        EditText TextEditBook = findViewById(R.id.editTextText);
        String userFavoriteBook = TextEditBook.getText().toString();
        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, userFavoriteBook);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
