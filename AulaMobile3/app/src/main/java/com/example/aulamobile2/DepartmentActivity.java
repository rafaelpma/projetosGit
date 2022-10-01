package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aulamobile2.model.DepartamentoRes;
import com.example.aulamobile2.service.DepartamentoService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;

    private List<DepartamentoRes> departments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);


        List<String> lista = new ArrayList<>();


        DepartamentoService retrofit = RetrofitConfig
                .newInstance()
                .departamentService();


        retrofit.getAll().enqueue(
                new Callback<List<DepartamentoRes>>() {
                    @Override
                    public void onResponse(Call<List<DepartamentoRes>> call, Response<List<DepartamentoRes>> response) {
                        departments = response.body();
                        for (DepartamentoRes item : departments) {
                            lista.add(item.getName());
                        }

                        customAdapter = new CustomAdapter(lista);

                        RecyclerView recyclerView = findViewById(R.id.rvList);
                        recyclerView.setAdapter(customAdapter);


                    }

                    @Override
                    public void onFailure(Call<List<DepartamentoRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                }
        );






    }
}