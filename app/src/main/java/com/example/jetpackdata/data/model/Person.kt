package com.example.jetpackdata.data.model

import androidx.databinding.ObservableField


// データクラス
// 何もしないデータを保持するだけのクラス

class Person(name:String, mail:String, age:Int){
    var name = ObservableField<String>()
    var mail = ObservableField<String>()
    var age = ObservableField<String>()

    init {
        this.name.set(name)
        this.mail.set(mail)
        this.age.set(age.toString())
    }

    fun to_s() : String = "${name.get()} (${mail.get()}, ${age.get()})"
}