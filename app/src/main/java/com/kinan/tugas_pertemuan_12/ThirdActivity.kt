package com.kinan.tugas_pertemuan_12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinan.tugas_pertemuan_12.databinding.ActivityThirdBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThirdActivity : AppCompatActivity() {
    private lateinit var mDuckDao: DuckTable
    private lateinit var executorService: ExecutorService
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityThirdBinding.inflate(layoutInflater)
        executorService = Executors.newSingleThreadExecutor()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val db = DuckDatabase.getDatabase(this)
        mDuckDao = db!!.duckTable()!!
        setSupportActionBar(findViewById(R.id.toolbar_ku))


        mDuckDao.allDucks.observe(this) {
            binding.rvBookmark.apply {
                adapter = DuckAdapter(it, { duck ->
                    // update
                    val intent = Intent(this@ThirdActivity, ForthActivity::class.java)
                    val id = duck.id
                    intent.putExtra("IMAGE", duck.url)
                    intent.putExtra("ID", duck.id)
                    startActivity(intent)
                }, { duck ->
                    // delete
                    delete(duck)
                })
            }
        }

        with(binding) {
            rvBookmark.apply {
                layoutManager = LinearLayoutManager(this@ThirdActivity)
            }
        }
    }
    private fun delete(duck: Duck) {
        executorService.execute {
            mDuckDao.delete(duck)
        }

    }
}