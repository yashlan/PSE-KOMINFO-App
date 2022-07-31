package com.yashlan.psekominfomonitor.ui.view.modelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yashlan.psekominfomonitor.di.Injection
import com.yashlan.psekominfomonitor.ui.view.model.PSEViewModel

@Suppress("UNCHECKED_CAST")
class PSEViewModelFactory(private val url: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PSEViewModel::class.java)) {
            PSEViewModel(Injection.provideRepository(url)) as T
        } else {
            throw IllegalArgumentException("ViewModel of ${modelClass.simpleName} Not Found")
        }
    }
}