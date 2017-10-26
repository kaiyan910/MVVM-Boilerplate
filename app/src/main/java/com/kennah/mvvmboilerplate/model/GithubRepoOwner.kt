package com.kennah.mvvmboilerplate.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GithubRepoOwner(
        @JsonProperty("avatar_url") val avatarUrl: String?
)