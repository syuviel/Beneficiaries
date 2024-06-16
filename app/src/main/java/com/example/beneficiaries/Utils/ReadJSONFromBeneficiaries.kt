package com.example.beneficiaries.Utils

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

fun ReadJSONFromBeneficiaries(context: Context, path: String): String {
    try {
        val file = context.assets.open(path)
        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        val jsonString = stringBuilder.toString()
        return jsonString
    } catch (e: Exception) {
        return ""
    }
}