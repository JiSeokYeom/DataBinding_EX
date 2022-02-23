package com.example.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding_ex.databinding.ActivityMainBinding
import com.example.databinding_ex.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    // by lazy로 값을 선언 해준 후 ViewModelProvider로 ViewModel를 만든다
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.like.setOnClickListener {
            viewModel.likeAdd()
        }

        binding.noLike.setOnClickListener {
            viewModel.noLikeAdd()
        }

        binding.reset.setOnClickListener {
            viewModel.reset()
        }

        observerViewModel()

    }

    private fun observerViewModel(){
        // 좋아요 개수
        viewModel.likeCount.observe(this,object : Observer<Int>{
            override fun onChanged(likeCount: Int?) {
                Log.d(TAG,"likeCount 변경 됨 likeCount 값 : $likeCount" )
            }
        })
        // 싫어요 개수
        viewModel.noLikeCount.observe(this, object : Observer<Int>{
            override fun onChanged(noLikeCount: Int?) {
                Log.d(TAG,"noLikeCount 변경 됨 noLikeCount 값 : $noLikeCount" )
            }
        })

        // 총 개수
        viewModel.totLikeCount.observe(this, object : Observer<Int>{
            override fun onChanged(totLikeCount: Int?) {
                Log.d(TAG,"totLikeCount 변경 됨 totLikeCount 값 : $totLikeCount" )
            }
        })
    }
}


