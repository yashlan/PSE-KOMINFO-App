package com.yashlan.psekominfomonitor.data

import com.yashlan.psekominfomonitor.api.ApiService

class Repository(private val apiService: ApiService) {
    fun getPSE() = apiService.getPSE()
}