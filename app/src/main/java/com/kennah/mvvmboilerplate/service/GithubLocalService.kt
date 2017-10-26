package com.kennah.mvvmboilerplate.service

import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.model.dao.RepositoryDao
import com.kennah.mvvmboilerplate.model.db.Repository


class GithubLocalService(private val repositoryDao: RepositoryDao) {

    fun getRepositories(language: String): List<GithubRepo> = repositoryDao.findRepositories("%$language%").map { GithubRepo.convert(it) }

    fun saveRepositories(repos: List<GithubRepo>) {
        repositoryDao.insertMany(repos.map { Repository.convert(it) })
    }

    fun deleteAllFromRepositories() = repositoryDao.deleteAll()
}