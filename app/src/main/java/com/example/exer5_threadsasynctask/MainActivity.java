package com.example.exer5_threadsasynctask;

import android.app.AutomaticZenRule;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button myBtnCount = findViewById(R.id.btnCount);
        myBtnCount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                startCountdown();

                Toast.makeText(MainActivity.this, "Meu botão foi clicado",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startCountdown() {
        Button myBtnCount2 = findViewById(R.id.btnCount);
        myBtnCount2.setEnabled(false);
        new CountDownTimer(10000, 1000) { // 10 segundos total, atualizando a cada 1 segundo
            final TextView myTvCount = findViewById(R.id.textView);

            @Override
            public void onTick(long millisUntilFinished) {
                // Atualiza o TextView com o tempo restante
                long secondsRemaining = millisUntilFinished / 1000; // Converte de milissegundos para segundos
                myTvCount.setText(String.valueOf(secondsRemaining));
            }

            @Override
            public void onFinish() {
                // Código a ser executado quando a contagem regressiva terminar
                myTvCount.setText("0");
                myBtnCount2.setEnabled(true);
            }
        }.start();
    }
}