package com.project.capstone.feature.auth.login.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
  @POST("login")
  fun login(@Body todo: User): Call<User>
}