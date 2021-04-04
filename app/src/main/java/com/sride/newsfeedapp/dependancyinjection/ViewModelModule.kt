package com.sride.newsfeedapp.dependancyinjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sride.newsfeedapp.ui.main.home.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindThemeViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
