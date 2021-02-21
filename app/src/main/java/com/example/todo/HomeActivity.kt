package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.base.BaseActivity
import com.example.todo.database.TaskDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        add_button.setOnClickListener{
            openAddTaskActivity()
        }
    }

    private fun openAddTaskActivity() {
        var intent = Intent(this,AddTaskActivity::class.java)
        startActivity(intent)
    }
}