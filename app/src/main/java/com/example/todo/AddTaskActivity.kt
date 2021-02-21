package com.example.todo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.todo.base.BaseActivity
import com.example.todo.database.TaskDatabase
import com.example.todo.database.dao.TaskDao
import com.example.todo.database.model.Task
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
           setUpViews()
        save_button.setOnClickListener {
            addTask()
        }
    }

    private fun setUpViews() {
        title_layout.editText?.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                  title_layout.error = null
            }
        })
        description_layout.editText?.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun afterTextChanged(s: Editable?) {
                description_layout.error = null
            }
        })
    }

    private fun addTask() {
        if(!validData())return
        val taskTitle = title_layout.editText?.text.toString()
        val taskDescription = description_layout.editText?.text.toString()
        val task = Task(description =taskDescription,title =taskTitle,isCompleted =completed_switch.isClickable)
        TaskDatabase.getInstance(applicationContext)
                .taskDao()
                .addTask(task)
        showDialoge(messageId = R.string.task_added_sucssesfully,posActionName = R.string.ok,
                posAction = DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    finish()
                })
    }

    private fun validData():Boolean {
        var isValid = true
        if (title_layout.editText?.text.toString().isBlank()) {
            var isValid = false
            title_layout.error = "please enter a valid title"
        }
        if (description_layout.editText?.text.toString().isBlank()) {
            var isValid = false
            description_layout.error = "please enter a valid description"
        }
        return isValid
    }
}