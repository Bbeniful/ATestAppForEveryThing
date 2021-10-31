package com.example.atestappforeverything.feature_data_store.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atestappforeverything.feature_data_store.data.preferences.MyDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val dataStore: MyDataStore
) : ViewModel() {


    fun saveData(data: Any) {
        viewModelScope.launch {
            dataStore.saveData(data)
        }
    }

    fun getData(): Flow<String?> {
        return dataStore.getStringData()
    }

    fun <T> getGenericData(type: String): T {
        return when (type) {
            "text" -> {
                dataStore.getStringData() as T
            }
            "numeric" -> {
                dataStore.getNumericData() as T
            }
            else -> String("No".toCharArray()) as T
        }
    }
}