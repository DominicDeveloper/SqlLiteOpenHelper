package com.asadbek.sqliteopenhelper.model

class User {
    var id:Int? = null
    var name:String? = null
    constructor()
    constructor(id: Int?, name: String?) {
        this.id = id
        this.name = name
    }

    constructor(name: String?) {
        this.name = name
    }


}