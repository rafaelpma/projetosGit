package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] colors = getResources().getStringArray(R.array.colors);

        List<String> lista = new ArrayList<>();
        lista.add("Rafael Paz");
        lista.add("Laura Paz");
        lista.add("Glaucione Paz");
        lista.add("Saulo Paz");
        lista.add("Rilda Paz");
        lista.add("Isaias Monteiro");
        lista.add("Ana Carla Paz");
        lista.add("Ana Carolina Paz");
        lista.add("Rodrigo");
        lista.add("Caio Lucas");

        customAdapter = new CustomAdapter(lista, colors);

        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setAdapter(customAdapter);
//
//        DepartamentoService retrofit = RetrofitConfig
//                .newInstance()
//                .departamentService();
//
//
//        retrofit.getAll().enqueue(
//                new Callback<List<DepartamentoRes>>() {
//                    @Override
//                    public void onResponse(Call<List<DepartamentoRes>> call, Response<List<DepartamentoRes>> response) {
//                        departments = response.body();
//                        for (DepartamentoRes item : departments) {
//                            lista.add(item.getName());
//                        }
//
//                        customAdapter = new CustomAdapter(lista, colors);
//
//                        RecyclerView recyclerView = findViewById(R.id.rvList);
//                        recyclerView.setAdapter(customAdapter);
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<DepartamentoRes>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
//                        t.printStackTrace();
//                    }
//                }
//        );






    }
}