package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aulamobile2.model.ProfessorRes;
import com.example.aulamobile2.service.ProfessorService;

import java.util.ArrayList;
import java.util.List;

public class ProfessorActivity extends AppCompatActivity {


    private CustomAdapter customAdapter;

    private List<ProfessorRes> professors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);


        List<String> lista = new ArrayList<>();


        ProfessorService retrofit = RetrofitConfig
                .newInstance()
                .professorService();


        retrofit.getAll().enqueue(
                new Callback<List<ProfessorRes>>() {
                    @Override
                    public void onResponse(Call<List<ProfessorRes>> call, Response<List<ProfessorRes>> response) {
                        professors = response.body();
                        for (ProfessorRes item : professors) {
                            lista.add(item.getName());
                        }

                        customAdapter = new CustomAdapter(lista);

                        RecyclerView recyclerView = findViewById(R.id.rvList);
                        recyclerView.setAdapter(customAdapter);


                    }

                    @Override
                    public void onFailure(Call<List<ProfessorRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                }
        );


    }

}