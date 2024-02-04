package com.example.mvvm.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.model.Nation
import com.example.mvvm.services.ApiService
import kotlinx.coroutines.launch

class NationViewModel: ViewModel() {
    var nationListResponse:List<Nation> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")

    fun getResult(query: String) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val response = apiService.getNations(query)
                Log.println(Log.ERROR, "NATION_VIEW_MODEL", response.toString())
                nationListResponse = response.country
            }catch (error: Exception) {
                errorMessage = error.message.toString()
                Log.e("NATION_VIEW_MODEL", errorMessage)
            }
        }
    }
}