package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aulamobile2.CustomAdapter;
import com.example.aulamobile2.R;
import com.example.aulamobile2.RetrofitConfig;
import com.example.aulamobile2.model.CursoRes;
import com.example.aulamobile2.service.CursoService;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;

    private List<CursoRes> courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);



        List<String> lista = new ArrayList<>();


        CursoService retrofit = RetrofitConfig
                .newInstance()
                .coursesService();


        retrofit.getAll().enqueue(
                new Callback<List<CursoRes>>() {
                    @Override
                    public void onResponse(Call<List<CursoRes>> call, Response<List<CursoRes>> response) {
                        courses = response.body();
                        for (CursoRes item : courses) {
                            lista.add(item.getName());
                        }

                        customAdapter = new CustomAdapter(lista);

                        RecyclerView recyclerView = findViewById(R.id.rvList);
                        recyclerView.setAdapter(customAdapter);


                    }

                    @Override
                    public void onFailure(Call<List<CursoRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                }
        );


    }




}