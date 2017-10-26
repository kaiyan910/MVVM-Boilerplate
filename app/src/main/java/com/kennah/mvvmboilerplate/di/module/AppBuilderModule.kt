package com.kennah.mvvmboilerplate.di.module

import android.app.Activity
import com.kennah.mvvmboilerplate.MainActivity
import com.kennah.mvvmboilerplate.di.component.MainComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(
        MainComponent::class
))
abstract class AppBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>
}