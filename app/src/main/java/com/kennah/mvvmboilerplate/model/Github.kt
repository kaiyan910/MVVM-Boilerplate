package com.kennah.mvvmboilerplate.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Github(
        @JsonProperty("total_count") val totalCount: Int?,
        @JsonProperty("items") val items: List<GithubRepo>?
)