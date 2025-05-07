package com.example.farmersinternational.Dto

class Designpatterns(val constructors: String,val  xyz: Long) {
    constructor( constructorsisFREAKINGPARAMETERS: String): this(constructors,0)

}

fun do(){
    val user2 = Designpatterns("yy", 12)
    val user1 = Designpatterns("woahboy")
    print(user2.constructors)
    print(user2.xyz)
    print(user1.constructors)
    print(user1.xyz)

}
//strategy pattern