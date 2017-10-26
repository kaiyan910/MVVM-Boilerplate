package com.kennah.mvvmboilerplate.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.model.GithubRepoOwner

@Entity(tableName = "repositories")
class Repository(
        @PrimaryKey @ColumnInfo(name = "id") var id: Int?,
        @ColumnInfo(name = "name") var name: String?,
        @ColumnInfo(name = "full_name") var fullName: String?,
        @ColumnInfo(name = "description") var description: String?,
        @Embedded var owner: GithubRepoOwner?
) {

    companion object {
        fun convert(repo: GithubRepo): Repository = Repository(repo.id, repo.name, repo.fullName, repo.description, repo.owner)
    }
}