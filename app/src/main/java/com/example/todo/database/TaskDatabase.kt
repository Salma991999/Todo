package com.example.todo.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.database.dao.TaskDao
import com.example.todo.database.model.Task


@Database (entities = [Task::class], version =1 )
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object{
       private var database :TaskDatabase? = null
        private var DATABASE_NAME ="tasks_db"
        fun getInstance(context: Context):TaskDatabase{
            if (database==null){
                //create
              database = Room.databaseBuilder(context , TaskDatabase::class.java , DATABASE_NAME)
                     .fallbackToDestructiveMigration()
                     .allowMainThreadQueries()
                     .build()
            }
            return database!!
        }
    }
}