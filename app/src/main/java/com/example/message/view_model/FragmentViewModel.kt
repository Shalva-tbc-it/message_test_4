package com.example.message.view_model

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream

class FragmentViewModel : ViewModel() {

    inline fun <reified T> parseJsonFromRaw(resources: Resources, rawResourceId: Int): T? {
        val inputStream: InputStream = resources.openRawResource(rawResourceId)
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val type = Types.newParameterizedType(List::class.java, Map::class.java)
        val adapter: JsonAdapter<T> = moshi.adapter(type)

        return adapter.fromJson(jsonString)
    }

}