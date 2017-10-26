package com.kennah.mvvmboilerplate.di.component

import com.kennah.mvvmboilerplate.MainActivity
import com.kennah.mvvmboilerplate.di.module.MainModule
import com.kennah.mvvmboilerplate.di.scope.MainScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@MainScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}