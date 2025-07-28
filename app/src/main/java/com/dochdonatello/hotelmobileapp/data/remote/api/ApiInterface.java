package com.dochdonatello.hotelmobileapp.data.remote.api;

import com.dochdonatello.hotelmobileapp.data.remote.models.response.ProductResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/products")
    Call<ProductResponse> getAllProduct();
}
