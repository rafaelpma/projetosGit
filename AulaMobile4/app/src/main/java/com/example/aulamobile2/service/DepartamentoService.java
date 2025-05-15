package com.example.aulamobile2.service;

import com.example.aulamobile2.model.Departamento;
import com.example.aulamobile2.model.DepartamentoRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartamentoService {


    @GET("/departments")
    Call<List<DepartamentoRes>> getAll();

    @POST("/departments")
    Call<List<DepartamentoRes>> createDepartment(@Body Departamento to);

    @GET("/departments/{department_id}")
    Call<List<DepartamentoRes>> getDepartmentByID(@Path("department_id") Long id);

    @PUT("/departments/{department_id}")
    Call<List<DepartamentoRes>> alterar(
            @Path("department_id") Long id,
            @Body Departamento to
    );

}
