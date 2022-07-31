package com.yashlan.psekominfomonitor.ui.view.model

import androidx.lifecycle.ViewModel
import com.yashlan.psekominfomonitor.data.Repository
import com.yashlan.psekominfomonitor.data.response.PSEResponse
import retrofit2.*

class PSEViewModel(private val repository: Repository) : ViewModel() {

    fun getPSE(
        onSuccess: (PSEResponse?) -> Unit,
        onFailed: (String?) -> Unit
    ) {
        val call = repository.getPSE()
        call.enqueue(object : Callback<PSEResponse> {
            override fun onResponse(
                call: Call<PSEResponse>,
                response: Response<PSEResponse>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    onFailed("${response.code()} : terjadi kesalahan")
                }
            }

            override fun onFailure(call: Call<PSEResponse>, t: Throwable) {
                onFailed("terjadi kesalahan")
            }
        })
    }
}