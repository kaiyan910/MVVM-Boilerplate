package com.kennah.mvvmboilerplate.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.kennah.mvvmboilerplate.AppDatabase
import com.kennah.mvvmboilerplate.di.scope.AppScope
import com.kennah.mvvmboilerplate.model.dao.RepositoryDao
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    @AppScope
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    @AppScope
    fun provideAppDatabase(app: Application): AppDatabase = Room.databaseBuilder(app, AppDatabase::class.java, "boilerplate-db").allowMainThreadQueries().build()

    @Provides
    @AppScope
    fun provideRepositoryDao(database: AppDatabase): RepositoryDao = database.repositoryDao()
}