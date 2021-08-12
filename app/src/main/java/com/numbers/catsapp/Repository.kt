package com.numbers.catsapp

import retrofit2.Response

class Repository {
    suspend fun getCats(): List<CatResponse>{
        return NetworkModule.theCatsApi.getCats()
    }
}