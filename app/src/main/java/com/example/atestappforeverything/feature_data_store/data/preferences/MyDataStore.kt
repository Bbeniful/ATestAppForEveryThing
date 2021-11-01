package com.example.atestappforeverything.feature_data_store.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.atestappforeverything.feature_data_store.utils.DataStoreKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MyDataStore(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DataStoreKeys.STORE_NAME)


    suspend fun saveData(data: Any) {
        context.dataStore.edit {

            when (data) {
                is String -> {
                    it[DataStoreKeys.TEST_TEXT] = data
                }
                is Int -> {
                    it[DataStoreKeys.TEST_NUMERIC] = data
                }
            }
        }
    }


    fun getStringData(): Flow<String?> = context.dataStore.data.map { it[DataStoreKeys.TEST_TEXT] }


    fun getNumericData(): Flow<Int?> = context.dataStore.data.map { it[DataStoreKeys.TEST_NUMERIC] }

}