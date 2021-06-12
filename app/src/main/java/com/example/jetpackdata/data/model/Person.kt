package com.example.jetpackdata.data.model

import androidx.databinding.ObservableField


// データクラス
// 何もしないデータを保持するだけのクラス

class Person(name:String, mail:String, age:Int){
    var name : String = name
    var mail : String = mail
    var age : Int = age

    fun age_s() : String = age.toString()
    fun to_s() : Any? = "$name : ($mail, $age)"
}