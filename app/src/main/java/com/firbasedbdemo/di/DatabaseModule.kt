package com.firbasedbdemo.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable


/**
 * @author Sino K D
 * @since 8/28/18.
 */

@Module
internal object DatabaseModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDatabaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

}