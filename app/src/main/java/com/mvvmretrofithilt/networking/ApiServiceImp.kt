package com.mvvmretrofithilt.networking

import com.mvvmretrofithilt.model.ProductResponseItem
import retrofit2.Response
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) : ApiService {
    override suspend fun getProducts(): Response<List<ProductResponseItem>> {
        return apiService.getProducts()
    }
}