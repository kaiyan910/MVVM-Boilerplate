package com.kennah.mvvmboilerplate.di.component

import android.app.Application
import com.kennah.mvvmboilerplate.App
import com.kennah.mvvmboilerplate.di.module.AppBuilderModule
import com.kennah.mvvmboilerplate.di.module.AppModule
import com.kennah.mvvmboilerplate.di.module.NetworkModule
import com.kennah.mvvmboilerplate.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named

@AppScope
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        AppBuilderModule::class,
        AndroidSupportInjectionModule::class
))
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        @BindsInstance
        fun server(@Named("server") url: String): Builder
        fun build(): AppComponent
    }
}