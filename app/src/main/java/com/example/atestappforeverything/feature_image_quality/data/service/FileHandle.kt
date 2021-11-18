package com.example.atestappforeverything.feature_image_quality.data.service

import android.R.attr
import android.content.Context
import com.example.atestappforeverything.core.presentation.Application
import android.R.attr.data
import android.util.Log
import java.io.*
import java.lang.StringBuilder


class FileHandle(
    private val context: Context
) {

    val PATH = context.getExternalFilesDir(null)?.absolutePath + "/"

    init {
        createFolder()
    }

    private fun createFolder() {
        val folder = File(PATH + "test_image_folder")
        if (!folder.exists()) {
            folder.mkdir()
        }
    }

    fun saveFile(file: File, data: String) {
        try {
            val outputStreamWriter =
                OutputStreamWriter(context.openFileOutput(file.path, Context.MODE_PRIVATE))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: $e")
        }
    }

    fun getFileAsStringData(): String {
        var ret = ""

        try {
            val inputStream: InputStream? = context.openFileInput("config.txt")
            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var receiveString: String? = ""
                val stringBuilder = StringBuilder()
                while (bufferedReader.readLine().also { receiveString = it } != null) {
                    stringBuilder.append("\n").append(receiveString)
                }
                inputStream.close()
                ret = stringBuilder.toString()
            }
        } catch (e: FileNotFoundException) {
            Log.e("login activity", "File not found: $e")
        } catch (e: IOException) {
            Log.e("login activity", "Can not read file: $e")
        }

        return ret
    }
}