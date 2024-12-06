package com.mvvmretrofithilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmretrofithilt.model.ProductResponseItem
import com.mvvmretrofithilt.networking.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) {
    private val _products = MutableLiveData<List<ProductResponseItem>>()
    val products: LiveData<List<ProductResponseItem>>
        get() = _products

    suspend fun getProducts(){
        val result = apiService.getProducts()
        if (result.isSuccessful && result.body()!= null){
            _products.postValue(result.body())
        }
    }
}