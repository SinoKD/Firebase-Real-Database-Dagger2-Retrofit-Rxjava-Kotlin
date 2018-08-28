package com.firbasedbdemo.ui.notes.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides


/**
 * @author Sino K D
 * @since 8/22/18.
 */
@Module
abstract class NotesModule {

    @Module
    companion object {
        val uid: String = FirebaseAuth.getInstance().getCurrentUser()!!.getUid()
        @JvmStatic
        @Provides
        fun provideFirebaseDatabaseReference(): DatabaseReference = FirebaseDatabase.getInstance().getReference("users").child(uid).child("Notes")
    }

}