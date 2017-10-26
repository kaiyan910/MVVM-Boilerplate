package com.kennah.mvvmboilerplate

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kennah.mvvmboilerplate.model.dao.RepositoryDao
import com.kennah.mvvmboilerplate.model.db.Repository

@Database(entities = arrayOf(Repository::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao
}