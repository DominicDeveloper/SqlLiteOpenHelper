package com.asadbek.sqliteopenhelper.`interface`

import com.asadbek.sqliteopenhelper.model.User

interface Reja {
    fun addUser(user: User)
    fun getAllUser():ArrayList<User>

}