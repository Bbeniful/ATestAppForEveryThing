package com.example.atestappforeverything.feature_image_quality.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import java.io.File
import java.io.FileInputStream

object FileHelpers {

    private const val IMAGE_EXTENSION = ".jpg"
    const val IMAGE_NAME = "my_image$IMAGE_EXTENSION"

    fun getImagePath(context: Context): String {
        return context.getExternalFilesDir(null)!!.path
    }

    fun getPathFromUri(context: Context, uri: Uri?): String {
        var result: String? = null
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context.contentResolver.query(uri!!, proj, null, null, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndexOrThrow(proj[0])
                result = cursor.getString(columnIndex)
            }
            cursor.close()
        }
        if (result == null) {
            result = "Not found"
        }
        return result
    }

    fun readImage(context: Context): Bitmap? {
        val imageFile = File("${getImagePath(context)}/$IMAGE_NAME")
        if (imageFile.exists()) {
            Log.e("readimage", " exist")
            return BitmapFactory.decodeStream(FileInputStream(imageFile))
        }
        return null
    }

    fun listFiles(context: Context) {
        val file = File(getImagePath(context))
        file.listFiles().forEach {
            Log.e("Files -> ", "${it.path} name -> ${it.name}")
        }
    }
}