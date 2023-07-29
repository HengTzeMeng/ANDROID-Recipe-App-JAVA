package com.example.ahmarecipe.interfaces

import com.example.ahmarecipe.entities.Category
import com.example.ahmarecipe.entities.CategoryItems
import com.example.ahmarecipe.entities.Meal
import com.example.ahmarecipe.entities.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>


}