package com.example.progmobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SmashAPI {
    @GET("/api/characters/")
    Call<List<Characters>> loadChanges();
}
