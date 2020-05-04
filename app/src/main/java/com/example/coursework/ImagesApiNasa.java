package com.example.coursework;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImagesApiNasa {
    @GET("/captions/172_ISS-Slosh")
    Call<Search> getData();
}