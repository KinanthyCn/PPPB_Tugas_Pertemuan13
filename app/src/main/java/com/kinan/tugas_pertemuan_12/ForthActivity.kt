package com.kinan.tugas_pertemuan_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kinan.tugas_pertemuan_12.databinding.ActivityForthBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ForthActivity : AppCompatActivity() {
    private lateinit var mDuckDao: DuckTable
    private lateinit var executorService: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityForthBinding.inflate(layoutInflater)
        executorService = Executors.newSingleThreadExecutor()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val db = DuckDatabase.getDatabase(this)
        mDuckDao = db!!.duckTable()!!
        val imgUrl = intent.getStringExtra("IMAGE")
        Glide.with(this).load(imgUrl).into(binding.imageView)

        with(binding){
            btnSubmit.setOnClickListener{
                update(
                    Duck(
                        id = intent.getIntExtra("ID", 0),
                        title = title.text.toString(),
                        description = description.text.toString(),
                        message = Message.text.toString(),
                        url = imgUrl!!
                    )
                )
                finish()
            }
        }
    }

    private fun update(duck: Duck) {
        executorService.execute {
            mDuckDao.update(duck)
        }
    }

}