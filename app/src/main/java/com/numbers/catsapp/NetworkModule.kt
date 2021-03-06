package com.numbers.catsapp

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

object NetworkModule  {
    private val baseUrl = "https://api.thecatapi.com/v1/"

    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    @ExperimentalSerializationApi
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()


    val theCatsApi: TheCatsApi = retrofitBuilder.create()

}