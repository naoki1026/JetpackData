package com.example.jetpackdata.data.viewModel

import androidx.lifecycle.ViewModel
import com.example.jetpackdata.data.model.Person

class MyViewModel : ViewModel() {

    // ViewModelにデータを保管しているため、回転させても消えない
    private val data: MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )

    fun getAll() : List<Person> = data
    fun getById(id:Int) : Person = data[id]
    fun add(name:String, mail:String, age:Int){
        val person = Person(name, mail, age)
        data.add(person)
    }
}





