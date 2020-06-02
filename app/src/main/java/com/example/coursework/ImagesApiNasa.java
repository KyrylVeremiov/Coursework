package com.example.coursework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImagesApiNasa {
    @GET("/search")
    Call<Search> search(@Query("q") Object q, @Query("center") Object center,@Query("description") Object description, @Query("description_508") Object description_508,
                        @Query("keywords") Object keywords , @Query("location") Object location ,@Query("media_type") Object media_type,
                        @Query("nasa_id") Object nasa_id , @Query("page") Object page  ,@Query("photographer") Object photographer,
                        @Query("secondary_creator") Object secondary_creator , @Query("title") Object title ,@Query("year_start") Object year_start,@Query("year_end") Object year_end);
}