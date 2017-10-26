package com.kennah.mvvmboilerplate.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.util.Log
import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.repository.GithubRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MainViewModel(app: Application, private val githubRepository: GithubRepository): AndroidViewModel(app) {

    var loading = ObservableField(false)
    var empty = ObservableField(false)
    var repositories = MutableLiveData<List<GithubRepo>>()

    fun loadRepositories(language: String) {

        empty.set(false)
        loading.set(true)

        async(UI) {

            val response = bg {
                githubRepository.getRepositories(language)
            }

            val githubRepositories = response.await()

            if (githubRepositories.isNotEmpty()) {
                val insert = bg {
                    githubRepository.saveToLocal(githubRepositories)
                }
                insert.await()
            }

            Log.d("DEBUG", "is_empty=${githubRepositories.isEmpty()}")
            empty.set(githubRepositories.isEmpty())
            repositories.value = githubRepositories

        }.invokeOnCompletion { e ->

            e?.apply {
                Log.e("DEBUG", message, this)
            }
            loading.set(false)
        }
    }

    fun cleanRepository() = githubRepository.deleteAllFromLocal()
}