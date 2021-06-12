package com.example.jetpackdata.viewModel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackdata.data.model.Person

class MyViewModel : ViewModel() {

    private val TAG = "MainViewModel"

    // ライブデータで扱うプロパティは全てvalで定数として宣言する必要がある
    val data : MutableLiveData<MutableList<Person>> by lazy {
        MutableLiveData<MutableList<Person>>()
    }

    val name : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mail : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val age : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val allText : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun allByText():String {
        var res = String()
        for(item in data.value!!){
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id:Int):Person = data.value!!.get(id)

    fun add(nm:String, ml:String, ag:Int){
        data.value?.add(Person(nm, ml, ag))
    }

    // MutableLiveDataプロパティの値の設定はinitメソッドで行なっている
    init  {
        data.value = mutableListOf(
            Person("Taro", "taro@yamada", 36),
            Person("Hanako", "hanako@flower", 25),
            Person("Sachiko", "sachiko@happy", 14)
        )

        // valueというプロパティは、MutableLiveDataで管理する値である
        allText.value = allByText()
        name.value = "name"
        mail.value = "mail@address"
        age.value = "0"
    }
}





