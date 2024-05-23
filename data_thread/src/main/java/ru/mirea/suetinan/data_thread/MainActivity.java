package ru.mirea.suetinan.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.mirea.suetinan.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.TextView.setText("После 2 сек задержки запускается процесс runn1");
                binding.TextView.append("\nrunn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.TextView.append("\nПосле 1 сек задержки запускается процесс runn2");
                binding.TextView.append("\nrunn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.TextView.append("\nТак как у процесса runn3 используется метод postDelayed" +
                        " с задержкой в 2000 мс, то он запускается через 2 секудны после запуска" +
                        " процесса runn2. хотя в коде и вызван раньше");
                binding.TextView.append("\nrunn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.TextView.postDelayed(runn3, 2000);
                    binding.TextView.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}