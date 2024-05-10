package ru.mirea.suetinan.buttonclicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewStudent;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;
    private CheckBox chbxWhoAmI;
    private CheckBox chbxItIsNotMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewStudent = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        chbxWhoAmI = findViewById(R.id.chbxWhoAmI);
        chbxItIsNotMe = findViewById(R.id.chbxItIsNotMe);

        View.OnClickListener oclBtnWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewStudent.setText("Мой номер по списку №29");
                chbxWhoAmI.toggle();
            }
        };
        btnWhoAmI.setOnClickListener(oclBtnWhoAmI);

    }

    public void oclBtnItIsNotMe(View view){
        textViewStudent.setText("Это не я сделал");
        chbxItIsNotMe.toggle();
    }
}