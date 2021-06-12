package com.example.jetpackdata.data.model


// データクラス
// 何もしないデータを保持するだけのクラス

class Person(name:String, mail:String, age:Int){
    val name = name
    val mail = mail
    val age = age

    fun to_s() : Any?{
        return "$name: ($mail, $age)"
    }
}