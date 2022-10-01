package com.example.aulamobile2.service;

import com.example.aulamobile2.model.Curso;
import com.example.aulamobile2.model.CursoRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {


    @GET("/courses")
    Call<List<CursoRes>> getAll();

    @POST("/courses")
    Call<List<CursoRes>> createCourse(@Body Curso to);

    @GET("/courses/{course_id}")
    Call<List<CursoRes>> getCourseByID(@Path("course_id") Long id);

    @PUT("/courses/{course_id}")
    Call<List<CursoRes>> alterar(
            @Path("course_id") Long id,
            @Body Curso to
    );

}
