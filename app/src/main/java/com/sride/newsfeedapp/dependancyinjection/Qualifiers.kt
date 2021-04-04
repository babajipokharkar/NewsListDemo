package com.sride.newsfeedapp.dependancyinjection

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class NewsApi

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScopeIO