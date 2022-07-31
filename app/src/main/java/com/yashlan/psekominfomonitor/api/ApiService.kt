package com.yashlan.psekominfomonitor.api

import com.yashlan.psekominfomonitor.data.response.PSEResponse
import retrofit2.*
import retrofit2.http.*

interface ApiService {

    @GET("/")
    fun getPSE(): Call<PSEResponse>
}