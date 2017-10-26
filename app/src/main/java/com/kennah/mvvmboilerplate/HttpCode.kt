package com.kennah.mvvmboilerplate

object HttpCode {

    @JvmField
    val NO_NETWORK = 0

    @JvmField
    val SUCCESS = 200
    @JvmField
    val UNAUTHORIZED = 401
    @JvmField
    val NOT_FOUND = 400
    @JvmField
    val INTERNAL_SERVER_ERROR = 500
    @JvmField
    val SERVER_UNAVAILABLE = 503
}