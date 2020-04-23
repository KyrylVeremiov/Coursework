package com.example.coursework;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImagesApiNasa {
    @GET("captions/172_ISS-Slosh")
    Call<List<Search>> getData(@Query("name") String resourceName);
}