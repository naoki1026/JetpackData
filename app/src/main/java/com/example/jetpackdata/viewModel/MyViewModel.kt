package com.example.jetpackdata.viewModel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackdata.data.model.Person

class MyViewModel : ViewModel() {

    var data : MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("Hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )

    fun allByText():String {
        var res = ""
        for (item in data) {
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id:Int) : Person = data[id]
    fun add(name:String, mail:String, age:Int) {
       data.add(Person(name, mail, age))
    }



}





