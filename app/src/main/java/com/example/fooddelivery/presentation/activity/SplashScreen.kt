package com.example.fooddelivery.presentation.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddelivery.R
import com.example.fooddelivery.utils.connection.CheckConnectionInMoment
import com.example.fooddelivery.utils.CONNECTED
import com.example.fooddelivery.utils.replaceActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    @Inject
    lateinit var checkConnection: CheckConnectionInMoment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onStart() {
        super.onStart()
        observConnection()
    }

    private fun observConnection(){
        CONNECTED = checkConnection.check()
        replaceActivity(this, MainActivity())
    }
}