package com.mvvmretrofithilt.model

data class ProductResponseItem(
    val _id: Int?=null,
    val category: String?=null,
    val description: String?=null,
    val image: String?=null,
    val isNew: Boolean?=null,
    val oldPrice: String?=null,
    val price: Double?=null,
    val rating: Int?=null,
    val title: String?=null
)