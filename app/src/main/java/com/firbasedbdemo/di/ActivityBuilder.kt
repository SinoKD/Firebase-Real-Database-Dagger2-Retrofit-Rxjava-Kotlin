package com.firbasedbdemo.di

import com.firbasedbdemo.ui.addnote.AddNoteActivity
import com.firbasedbdemo.ui.login.SignInActivity
import com.firbasedbdemo.ui.login.di.SignInModule
import com.firbasedbdemo.ui.notes.NotesActivity
import com.firbasedbdemo.ui.notes.di.NotesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Sino K D
 * @since 8/22/18.
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(NotesModule::class))
    internal abstract fun bindNotesActivityActivity(): NotesActivity

    @ContributesAndroidInjector(modules = arrayOf(NotesModule::class))
    internal abstract fun bindAddNoteActivity(): AddNoteActivity


    @ContributesAndroidInjector(modules = arrayOf(SignInModule::class))
    internal abstract fun bindLoginActivity(): SignInActivity
}