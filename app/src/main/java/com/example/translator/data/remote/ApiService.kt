package com.example.translator.data.remote

import com.example.translator.data.remote.response.TranslationResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface ApiService{
    @GET("api/public/v1/words/search")
    suspend fun loadTranslation(@Query("search") search: String): TranslationResponse
}