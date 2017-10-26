package com.kennah.mvvmboilerplate

import com.kennah.mvvmboilerplate.model.Github
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("/search/repositories?sort=stars&order=desc")
    fun getRepositories(@Query(value="q", encoded = true) language: String): Call<Github>
}