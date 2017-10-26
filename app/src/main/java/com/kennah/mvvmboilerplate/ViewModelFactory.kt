package com.kennah.mvvmboilerplate

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import com.kennah.mvvmboilerplate.repository.GithubRepository
import android.arch.lifecycle.ViewModel
import com.kennah.mvvmboilerplate.viewModel.MainViewModel


class ViewModelFactory(private val app: Application, private val githubRepository: GithubRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(app, githubRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}