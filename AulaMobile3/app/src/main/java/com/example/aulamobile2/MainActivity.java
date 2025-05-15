package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatButton = findViewById(R.id.floatButton);
        floatButton.setOnClickListener( v -> {
            Toast.makeText(getApplicationContext(),
                    "Imagem excluida com sucesso!", Toast.LENGTH_LONG).show();
        });
    }
}