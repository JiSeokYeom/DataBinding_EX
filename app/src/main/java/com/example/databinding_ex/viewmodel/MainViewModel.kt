package com.example.databinding_ex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

        var totLikeString : MutableLiveData<String> = MutableLiveData()
        var likeString : MutableLiveData<String> = MutableLiveData()
        var noLikeString : MutableLiveData<String> = MutableLiveData()
        var likeCount : MutableLiveData<Int> = MutableLiveData()
        var noLikeCount : MutableLiveData<Int> = MutableLiveData()
        var totLikeCount : MutableLiveData<Int> = MutableLiveData()

    init {
        likeString.value = "0개"
        likeCount.value = 0
        noLikeCount.value = 0
        totLikeCount.value = 0
    }

    fun likeAdd(){
        likeCount.value = likeCount.value?.plus(1)
        totLikeCount.value = likeCount.value?.minus(noLikeCount.value!!)
    }

    fun likeMinus(){
        noLikeCount.value = noLikeCount.value?.plus(1)
        totLikeCount.value = likeCount.value?.minus(noLikeCount.value!!)
    }

    fun reset(){
        totLikeCount.value = 0
        likeCount.value = 0
        noLikeCount.value = 0
    }
}