package com.mvvmretrofithilt.networking

import com.mvvmretrofithilt.model.ProductResponse
import com.mvvmretrofithilt.model.ProductResponseItem
import com.mvvmretrofithilt.utils.Constants.PRODUCTS_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(PRODUCTS_END_POINT)
    suspend fun getProducts(): Response<List<ProductResponseItem>>
}