package com.example.aulamobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aulamobile2.model.AllocationsRes;
import com.example.aulamobile2.service.AllocationService;

import java.util.ArrayList;
import java.util.List;

public class AllocationActivity extends AppCompatActivity {



    private CustomAdapter customAdapter;

    private List<AllocationsRes> allocations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation);



        List<String> lista = new ArrayList<>();


        AllocationService retrofit = RetrofitConfig
                .newInstance()
                .allocationService();


        retrofit.getAll().enqueue(
                new Callback<List<AllocationsRes>>() {
                    @Override
                    public void onResponse(Call<List<AllocationsRes>> call, Response<List<AllocationsRes>> response) {
                        allocations = response.body();
                        for (AllocationsRes item : allocations) {
                            String aux = "Professor: "+ item.getProfessor().getName() +
                                    "\nCurso: " +item.getCourse().getName()+
                                    "\nDia: "+item.getDayOfWeek() +
                                    "\nInício: " + item.getStartHour().substring(0,5) +
                                    "\nFim: " + item.getEndHour().substring(0,5);

                            lista.add(aux);
                        }

                        customAdapter = new CustomAdapter(lista);

                        RecyclerView recyclerView = findViewById(R.id.rvList);
                        recyclerView.setAdapter(customAdapter);


                    }

                    @Override
                    public void onFailure(Call<List<AllocationsRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na requisição!", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                }
        );


    }

}