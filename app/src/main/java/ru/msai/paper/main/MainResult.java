package ru.msai.paper.main;

import retrofit2.Call;
import retrofit2.http.GET;

interface MainResult {

    // Inquiries
    @GET("paper.php")
    Call<MainResponse> getResponseResult();
}
