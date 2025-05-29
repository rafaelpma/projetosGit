package com.example.aulamobile2.service;

import com.example.aulamobile2.model.Professor;
import com.example.aulamobile2.model.ProfessorRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfessorService {


    @GET("/professors")
    Call<List<ProfessorRes>> getAll();

    @POST("/professors")
    Call<List<ProfessorRes>> createDepartment(@Body Professor to);

    @GET("/professors/{professor_id}")
    Call<List<ProfessorRes>> getDepartmentByID(@Path("professor_id") Long id);

    @PUT("/professors/{professor_id}")
    Call<List<ProfessorRes>> alterar(
            @Path("professor_id") Long id,
            @Body Professor to
    );

}
