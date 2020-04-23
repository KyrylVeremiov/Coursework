package com.example.coursework;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImagesApiNasa {
    @GET("/captions")
    Call<List<Search>> getData(@Query("name") String resourceName);
}