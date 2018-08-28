package com.firbasedbdemo.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


/**
 * @author Sino K D
 * @since 8/22/18.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    DatabaseModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}