package com.example.fooddelivery.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ActivityMainBinding
import com.example.fooddelivery.utils.connection.CheckConnection
import com.example.fooddelivery.utils.APP_ACTIVITY_MAIN
import com.example.fooddelivery.utils.CONNECTED
import com.example.fooddelivery.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mNavController: NavController
    private lateinit var binding : ActivityMainBinding
    private lateinit var mCheckConnection: Observer<Boolean>

    @Inject
    lateinit var checkConnection: CheckConnection
    var isConnectChange = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        observConnection()
    }

    private fun observConnection(){
        mCheckConnection = Observer{
            if(it){
                if(isConnectChange){
                    showSnackBar(binding.navigationView, getString(R.string.is_connected), R.color.colorGreen)
                }
            }
            else{
                isConnectChange = true
                showSnackBar(binding.navigationView, getString(R.string.not_connected), R.color.colorRed)
            }
            CONNECTED = it
        }
        checkConnection.observe(APP_ACTIVITY_MAIN, mCheckConnection)
    }

    private fun initFields(){
        APP_ACTIVITY_MAIN = this
        mNavController = Navigation.findNavController(APP_ACTIVITY_MAIN, R.id.nav_host_fragment_main)
        binding.navigationView.setupWithNavController(mNavController)
    }
}