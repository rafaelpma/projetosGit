package com.example.aulamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToast = findViewById(R.id.btToast);

        btnToast.setOnClickListener(b -> {
            Toast.makeText(this, "Teste de Toast!!!", Toast.LENGTH_LONG).show();
        });

        Button btnCounter = findViewById(R.id.button2);
        TextView tvText = findViewById(R.id.tvNumero);

        btnCounter.setOnClickListener(b -> {
            Integer numero = Integer.parseInt(tvText.getText().toString());
            ++numero;
            tvText.setText(numero.toString());
        });

    }

}