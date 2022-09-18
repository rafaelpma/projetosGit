package com.example.aulamobile2;

import com.example.aulamobile2.service.DepartamentoService;

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
}
