package com.matt2393.kotlinmultiparadigma.Modelo.Entitys

data class ResponsePersonajes(var info: Info,
                              var results: ArrayList<Personaje>){
    constructor():this(Info(), ArrayList())
}

data class Personaje(var id: Int,
                     var name: String,
                     var status: String,
                     var species: String,
                     var gender: String,
                     var origin: Origin,
                     var image: String){
    constructor():this(0,"","","",
        "", Origin(),"")
}

data class Origin(var name: String){
    constructor():this("")
}

data class Info(var count: Int,
                var pages: Int,
                var next: String,
                var prev: String){
    constructor():this(0,0,"","")
}
