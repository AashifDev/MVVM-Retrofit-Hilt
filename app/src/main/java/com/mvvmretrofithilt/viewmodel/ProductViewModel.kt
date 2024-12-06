package com.mvvmretrofithilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvmretrofithilt.model.ProductResponseItem
import com.mvvmretrofithilt.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {
    val productLiveData : LiveData<List<ProductResponseItem>>
        get() = repository.products


    init {
        viewModelScope.launch{
            repository.getProducts()
        }
    }
}