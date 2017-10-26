package com.kennah.mvvmboilerplate.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.kennah.mvvmboilerplate.model.db.Repository

@JsonIgnoreProperties(ignoreUnknown = true)
class GithubRepo(
        @JsonProperty("id") val id: Int?,
        @JsonProperty("name") val name: String?,
        @JsonProperty("full_name") val fullName: String?,
        @JsonProperty("description") val description: String?,
        @JsonProperty("owner") val owner: GithubRepoOwner?
) {

    companion object {

        fun convert(repository: Repository): GithubRepo = GithubRepo(repository.id, repository.name, repository.fullName, repository.description, repository.owner)
    }
}