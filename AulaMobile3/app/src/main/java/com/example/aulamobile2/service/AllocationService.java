package com.example.aulamobile2.service;

import com.example.aulamobile2.model.AllocationsRes;
import com.example.aulamobile2.model.Allocations;
import com.example.aulamobile2.model.CursoRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllocationService {

    @GET("/allocations")
    Call<List<AllocationsRes>> getAll();

    @POST("/allocations")
    Call<List<AllocationsRes>> createCourse(@Body Allocations to);

    @GET("/allocations/{allocation_id}")
    Call<List<AllocationsRes>> getCourseByID(@Path("course_id") Long id);

    @PUT("/allocations/{allocations_id}")
    Call<List<CursoRes>> alterar(
            @Path("allocations_id") Long id,
            @Body Allocations to
    );
}
