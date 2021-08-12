package com.numbers.catsapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

private const val API_KEY = "500af210-1645-4976-8051-ca0e1b4a7501"

interface TheCatsApi {
    @GET("images/search?limit=50&page=100&order=DESC")

    suspend fun getCats(@Header("x-api-key") apiKey: String = API_KEY) : List<CatResponse>
}