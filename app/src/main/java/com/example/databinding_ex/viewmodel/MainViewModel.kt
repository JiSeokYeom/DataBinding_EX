package com.example.databinding_ex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var likeCount : MutableLiveData<Int> = MutableLiveData()
    var noLikeCount : MutableLiveData<Int> = MutableLiveData()
    var totLikeCount : MutableLiveData<Int> = MutableLiveData()

    init {
        likeCount.value = 0
        noLikeCount.value = 0
        totLikeCount.value = 0
    }
    // 좋아요 버튼
    fun likeAdd(){
        likeCount.value = likeCount.value?.plus(1)
        totLikeCount.value = likeCount.value?.minus(noLikeCount.value!!)
    }

    // 싫어요 버튼
    fun noLikeAdd(){
         noLikeCount.value = noLikeCount.value?.plus(1)
         totLikeCount.value = likeCount.value?.minus(noLikeCount.value!!)
    }

    // 초기화 버튼
    fun reset(){
        totLikeCount.value = 0
        likeCount.value = 0
        noLikeCount.value = 0
    }
}