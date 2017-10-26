package com.kennah.mvvmboilerplate.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.kennah.mvvmboilerplate.model.db.Repository

@Dao
interface RepositoryDao {

    @Query("SELECT * FROM repositories WHERE description LIKE :search OR name LIKE :search")
    fun findRepositories(search: String): List<Repository>

    @Insert(onConflict = REPLACE)
    fun insertMany(repository: List<Repository>)

    @Query("DELETE FROM repositories")
    fun deleteAll()
}