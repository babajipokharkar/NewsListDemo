package com.sride.newsfeedapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.sride.newsfeedapp.databinding.MainActivityBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() , HasSupportFragmentInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var navController: NavController

    override fun supportFragmentInjector(): AndroidInjector<Fragment>  = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : MainActivityBinding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        navController = findNavController(R.id.nav_fragment)
    }
}
