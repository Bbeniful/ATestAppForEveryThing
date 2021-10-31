package com.example.atestappforeverything.feature_data_store.utils

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DataStoreKeys {

    const val STORE_NAME = "STORE_NAME"
    val TEST_TEXT = stringPreferencesKey("TEST_TEXT")
    val TEST_NUMERIC = intPreferencesKey("TEST_NUMERIC")

}