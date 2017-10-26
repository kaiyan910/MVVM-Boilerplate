package com.kennah.mvvmboilerplate.repository

import android.app.Application
import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.service.GithubLocalService
import com.kennah.mvvmboilerplate.service.GithubRemoteService
import com.kennah.mvvmboilerplate.utils.CommonUtils

class GithubRepository(
        private val app: Application,
        private val remote: GithubRemoteService,
        private val local: GithubLocalService
) {

    fun getRepositories(language: String): List<GithubRepo> {

        return if (CommonUtils.hasNetwork(app)) {
            remote.getRepositories(language)
        } else {
            local.getRepositories(language)
        }
    }

    fun saveToLocal(repos: List<GithubRepo>) {
        local.saveRepositories(repos)
    }

    fun deleteAllFromLocal() = local.deleteAllFromRepositories()
}