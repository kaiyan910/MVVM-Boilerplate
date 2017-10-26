package com.kennah.mvvmboilerplate.di.module

import android.app.Application
import com.kennah.mvvmboilerplate.GithubApi
import com.kennah.mvvmboilerplate.RepositoryListAdapter
import com.kennah.mvvmboilerplate.ViewModelFactory
import com.kennah.mvvmboilerplate.di.scope.MainScope
import com.kennah.mvvmboilerplate.model.dao.RepositoryDao
import com.kennah.mvvmboilerplate.repository.GithubRepository
import com.kennah.mvvmboilerplate.service.GithubLocalService
import com.kennah.mvvmboilerplate.service.GithubRemoteService
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideGithubLocalService(repositoryDao: RepositoryDao): GithubLocalService = GithubLocalService(repositoryDao)


    @MainScope
    @Provides
    fun provideGithubRemoteService(app: Application, api: GithubApi): GithubRemoteService = GithubRemoteService(app, api)

    @MainScope
    @Provides
    fun provideGithubRepository(app: Application,
                                localService: GithubLocalService,
                                remoteService: GithubRemoteService): GithubRepository = GithubRepository(app, remoteService, localService)

    @MainScope
    @Provides
    fun provideViewModelFactory(app: Application, githubRepository: GithubRepository): ViewModelFactory = ViewModelFactory(app, githubRepository)

    @MainScope
    @Provides
    fun provideRepositoryListAdapter(): RepositoryListAdapter = RepositoryListAdapter()
}