package com.example.myapplication.model.rest

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myapplication.model.MovieDTO
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class MovieLoader {
    val KEY = "ca12a3835303780bedf8aaa882c241fa"

    fun loaderMovie(query: String): MovieDTO? {
        try {
            val uri = URL("https://api.themoviedb.org/3/search/movie?api_key=${KEY}&language=ru-RU&query=${query}&page=1&include_adult=false")

            lateinit var urlConnection: HttpsURLConnection
            try {
                urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.readTimeout = 200000
                val bufferedReader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val lines = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    getLinesForOld(bufferedReader)
                } else {
                    getLines(bufferedReader)
                }
                val fromJson = Gson().fromJson(lines, MovieDTO::class.java)
                return fromJson
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                urlConnection.disconnect()
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        return null
    }
    private fun getLinesForOld(reader: BufferedReader): String {
        val rawData = StringBuilder(1024)
        var tempVariable: String?

        while (reader.readLine().also { tempVariable = it } != null) {
            rawData.append(tempVariable).append("\n")
        }

        reader.close()
        return rawData.toString()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }
    }
