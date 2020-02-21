package com.asama.luong.golaovietmvp.util

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

object FileUtil {

    @Throws(IOException::class)
    fun loadJSOnFromAsset(context: Context, jsonFileName: String) : String {
        context.assets.open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            return String(buffer, Charset.forName("UTF-8"))
        }
    }
}