package com.semenov.retrofitproject.service;

//import com.example.retrofitgithubapi.model.GitHubRepo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.semenov.retrofitproject.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by norman on 12/26/16.
 */

public interface Client {

    @GET("qotd")
    Call <Example> reposForUser();
}
