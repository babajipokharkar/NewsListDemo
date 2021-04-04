package com.sride.newsfeedapp

import android.app.Activity
import android.app.Application
import com.sride.newsfeedapp.dependancyinjection.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class NewsApp : Application(), HasActivityInjector {
    @Inject
    public lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}