package com.kennah.mvvmboilerplate.utils

import android.content.Context
import android.net.ConnectivityManager
import com.kennah.mvvmboilerplate.exception.NetworkException


object CommonUtils {

    @Throws(NetworkException::class)
    fun checkNetwork(context: Context) {
        if (!hasNetwork(context)) throw NetworkException()
    }

    fun hasNetwork(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = manager.activeNetworkInfo
        return info != null && info.isConnectedOrConnecting
    }
}