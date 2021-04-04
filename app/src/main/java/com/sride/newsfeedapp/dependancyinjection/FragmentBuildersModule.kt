package com.sride.newsfeedapp.dependancyinjection

import com.sride.newsfeedapp.ui.main.home.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeThemeFragment(): MainFragment

}