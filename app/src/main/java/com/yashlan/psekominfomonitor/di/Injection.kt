package com.yashlan.psekominfomonitor.di

import com.yashlan.psekominfomonitor.api.ApiConfig
import com.yashlan.psekominfomonitor.data.Repository

object Injection {
    fun provideRepository(url: String): Repository {
        val apiConfig = ApiConfig.getApiService(url)
        return Repository(apiConfig)
    }
}