package com.example.a2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    public static String baseurl="https://api.thedogapi.com/v1/";


    static Gson gson= new GsonBuilder()
            .setLenient()
            .create();
    public static retrofit2.Retrofit retrofit;
    public static retrofit2.Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new retrofit2.Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
