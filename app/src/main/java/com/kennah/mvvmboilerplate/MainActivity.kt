package com.kennah.mvvmboilerplate

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.kennah.mvvmboilerplate.databinding.ActivityMainBinding
import com.kennah.mvvmboilerplate.model.GithubRepo
import com.kennah.mvvmboilerplate.model.GithubRepoOwner
import com.kennah.mvvmboilerplate.model.dao.RepositoryDao
import com.kennah.mvvmboilerplate.model.db.Repository
import com.kennah.mvvmboilerplate.viewModel.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mBindings: ActivityMainBinding

    @Inject
    lateinit var mFactory: ViewModelFactory
    @Inject
    lateinit var mListAdapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this, mFactory).get(MainViewModel::class.java)

        mBindings = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBindings.viewModel = viewModel
        mBindings.executePendingBindings()

        mBindings.list.layoutManager = LinearLayoutManager(this)
        mBindings.list.adapter = mListAdapter

        viewModel.repositories.observe(this, Observer<List<GithubRepo>> { it?.let { mListAdapter.setData(it) } })
    }


}
