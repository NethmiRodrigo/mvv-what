package com.example.mvvm.model

data class ApiResponse(
    val count : Int,
    val name : String,
    val country : List<Nation>
)

