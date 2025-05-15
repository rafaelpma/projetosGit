package com.example.aulamobile2;

import com.example.aulamobile2.service.AllocationService;
import com.example.aulamobile2.service.DepartamentoService;
import com.example.aulamobile2.service.ProfessorService;
import com.example.aulamobile2.service.CursoService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitConfig newInstance() {
        return new RetrofitConfig();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public DepartamentoService departamentService() {
        return retrofit.create(DepartamentoService.class);
    }

    public CursoService coursesService() {
        return retrofit.create(CursoService.class);
    }

    public ProfessorService professorService() {
        return retrofit.create(ProfessorService.class);
    }

    public AllocationService allocationService() {
        return retrofit.create(AllocationService.class);
    }
}
