package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Handler()
        .postDelayed( { startHomeActivity()
        },1000)
        }

    private fun startHomeActivity() {
    val intent = Intent(this@MainActivity, HomeActivity::class.java)
    startActivity(intent)
    finish()

}
}