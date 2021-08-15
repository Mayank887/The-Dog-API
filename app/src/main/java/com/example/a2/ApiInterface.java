package com.example.a2;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("breeds")
    Call<List<Pojo>> getPojo();

}
