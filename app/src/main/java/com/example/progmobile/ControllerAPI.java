package com.example.progmobile;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerAPI implements Callback<List<Characters>>{
    static final String BASE_URL = "http://beta-api-kuroganehammer.azurewebsites.net/";
    private MainActivity view;

    public ControllerAPI(MainActivity view) {
        this.view = view;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        SmashAPI smashAPI = retrofit.create(SmashAPI.class);

        Call<List<Characters>> call = smashAPI.loadChanges();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Characters>> call, Response<List<Characters>> response) {
        if(response.isSuccessful()) {
            List<Characters> changesList = response.body();
            view.initRecycler(changesList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Characters>> call, Throwable t) {
        t.printStackTrace();
        //Au cas ou le téléphone n est pas encore connecté a internet, on réessaie jusqu'à l'être
        this.start();
    }
}
