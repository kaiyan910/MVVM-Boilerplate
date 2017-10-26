package com.kennah.mvvmboilerplate.utils

import android.content.Context
import android.util.Log
import com.kennah.mvvmboilerplate.HttpCode
import com.kennah.mvvmboilerplate.exception.CoreException
import com.kennah.mvvmboilerplate.exception.NetworkException
import retrofit2.Response
import java.io.IOException


object ServiceUtils {

    @Throws(CoreException::class)
    fun <T> call(context: Context, invoke: () -> Response<T>): T {

        try {
            val response: Response<T> = invoke()
            when {
                response.isSuccessful -> {
                    return response.body()!!
                }
                else -> throw CoreException(response.code())
            }
        } catch (e: IOException) {
            Log.e("DEBUG", e.message, e)
            throw CoreException(HttpCode.SERVER_UNAVAILABLE)
        } catch (e: IllegalArgumentException) {
            Log.e("DEBUG", e.message, e)
            throw CoreException(HttpCode.SERVER_UNAVAILABLE)
        }
    }
}