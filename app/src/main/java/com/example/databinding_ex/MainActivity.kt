package com.example.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.databinding_ex.databinding.ActivityMainBinding
import com.example.databinding_ex.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // viewModel 생성
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

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

     //   observerViewModel()

    }

/*    private fun observerViewModel(){
        // 좋아요 개수
        viewModel.likeCount.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                Log.d("aaa", t.toString())
           //     viewModel.likeCount.value.toString() = "${viewModel.likeCount.value}개"
            }
        })

        // 싫어요 개수
        viewModel.noLikeCount.observe(this, object : Observer<Int>{
            override fun onChanged(t: Int?) {

            }
        })

        // 총 개수
        viewModel.totLikeCount.observe(this, object : Observer<Int>{
            override fun onChanged(t: Int?) {

            }
        })
    }*/
}