package com.livefront.bridgesample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livefront.bridgesample.R
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
