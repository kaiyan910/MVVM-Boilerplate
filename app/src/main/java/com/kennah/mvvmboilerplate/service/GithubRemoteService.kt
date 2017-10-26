package com.kennah.mvvmboilerplate.service

import android.app.Application
import com.kennah.mvvmboilerplate.GithubApi
import com.kennah.mvvmboilerplate.model.Github
import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.utils.ServiceUtils

class GithubRemoteService(private val app: Application, private val api: GithubApi) {

    fun getRepositories(language: String): List<GithubRepo> {

        val response = ServiceUtils.call<Github>(app) {

            val query = "language:$language+stars:1..10000"
            api.getRepositories(query).execute()
        }

        val size = response.items?.size ?: 0

        return if (size > 0) {
            response.items!!
        } else {
            emptyList()
        }
    }
}