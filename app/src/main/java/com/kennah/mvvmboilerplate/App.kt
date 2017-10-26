package com.kennah.mvvmboilerplate

import android.app.Application
import com.kennah.mvvmboilerplate.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class App: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder()
            .application(this)
            .server("https://api.github.com")
            .build()
}