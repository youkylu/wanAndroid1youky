package com.example.wanandroidyouky1

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.wanandroidyouky1.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.wanAndroid.auth.view.LoginFragment
import com.wanAndroid.home.view.HomeFragment
import com.wanAndroid.profile.view.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mPermissionLauncher: ActivityResultLauncher<String>

    private val viewModel: MainViewModel by viewModels()
    private var curposition = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkStoragePermission()
        binding.navView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_home -> {
                    curposition = 1
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, HomeFragment()).commit()
                }
                else -> {
                    curposition = 2
                    if (viewModel.loginDataSaved.value) {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment_activity_main, ProfileFragment())
                            .commit()
                    } else {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment_activity_main, LoginFragment()).commit()
                    }
                }
            }

            true
        }
        viewModel.loginState.observe(this, Observer { isLogin->
           if(isLogin && curposition ==2){
               var fragment: Fragment =  ProfileFragment()
               supportFragmentManager.beginTransaction()
                   .replace(R.id.nav_host_fragment_activity_main, fragment).commit()
            } else if(!isLogin && curposition ==2){
               supportFragmentManager.beginTransaction()
                   .replace(R.id.nav_host_fragment_activity_main, LoginFragment()).commit()
            }
        })
    }


    fun checkStoragePermission() {
        mPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                if (it) {
                    Toast.makeText(this@MainActivity, "成功请求权限", Toast.LENGTH_LONG).show()
                } else {
                    val shouldShow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
                    } else {
                        false
                    }
                    if (shouldShow) {
                        Toast.makeText(this@MainActivity, "没有存储权限，请手动授权", Toast.LENGTH_SHORT).show()
                    }else{
                        //TODO
                    }

                }
            }
        mPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }


}