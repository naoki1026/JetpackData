package com.example.jetpackdata.viewModel

import androidx.lifecycle.ViewModel
import com.example.jetpackdata.data.model.Person

class MyViewModel : ViewModel() {

    // ViewModelにデータを保管しているため、回転させても消えない
    private val data: MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )

    var person : Person = Person("new user", "new@address", 0)
    var allText : String = ""

    fun allByText() : String {
        var res = ""
        for (item in data){
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id:Int) : Person = data[id]
    fun add(name:String, mail:String, age:Int){
        val person = Person(name, mail, age)
        data.add(person)
    }

    init  {
        allText = allByText()
    }
}





