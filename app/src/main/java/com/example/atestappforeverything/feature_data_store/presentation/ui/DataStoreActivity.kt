package com.example.atestappforeverything.feature_data_store.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.atestappforeverything.databinding.DataStoreViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow

@AndroidEntryPoint
class DataStoreActivity : AppCompatActivity() {

    private lateinit var binding: DataStoreViewBinding
    private val viewModel: DataStoreViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataStoreViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dataStoreBtn.setOnClickListener {
            val text = binding.dataStoreTV.text.toString()
            saveData(text)
        }
        getSavedData()
        testData<String>()
    }

    private fun getSavedData() {
        with(binding) {
            viewModel.getData().asLiveData().observe(this@DataStoreActivity) {
                if (it is String) {
                    if (it.matches(".*\\d.*".toRegex())) {
                        if (it.contains(",")) {
                            val dataAsArray = it.split(",")
                            stringData.text = dataAsArray[0]
                            numericData.text = dataAsArray[1]
                        } else {
                            numericData.text = it
                        }
                    } else {
                        stringData.text = it
                    }
                }
            }
        }

    }

    private fun saveData(data: Any) {
        viewModel.saveData(data)
    }

    fun getDataGeneric(type: String){
        if (type == "text") {
            (viewModel.getGenericData<String>(type) as Flow<String?>).asLiveData().observe(this) {

            }
        }

        if (type == "numeric") {
            (viewModel.getGenericData<Int>(type) as Flow<Int?>).asLiveData().observe(this) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    fun <T> testData(): T {
        return String() as T
    }
}