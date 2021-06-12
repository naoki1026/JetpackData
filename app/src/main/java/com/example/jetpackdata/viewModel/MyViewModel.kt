package com.example.jetpackdata.viewModel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.jetpackdata.data.model.Person

class MyViewModel : ViewModel() {

    private val TAG = "MainViewModel"

    // ViewModelにデータを保管しているため、回転させても消えない
    private val data = ObservableArrayList<Person>().apply {
        add(Person("Taro", "taro@yamada", 36))
        add(Person("hanako", "hanako@flower", 25))
        add(Person("Sachiko", "sachiko@happy", 14))
    }

    val person = ObservableField<Person>()
    var allText = ObservableField<String>()

    fun allByText():String {
        var res = String()
        for(item in data){
            Log.d(TAG, "${item}")
            res += item.to_s()
            res += "\n"
        }
        return res
    }


//    fun getById(id:Int) : Person = data[id]
    fun add(name:String, mail:String, age:Int){
        this.add(Person(name, mail, age))
    }

    private fun add(person: Person){
        data.add(person)
    }

    init  {
        allText.set(allByText())
        person.set(Person("", "", 0))
    }
}





