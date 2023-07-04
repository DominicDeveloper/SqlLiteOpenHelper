package com.asadbek.sqliteopenhelper.offline

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.asadbek.sqliteopenhelper.`interface`.Reja
import com.asadbek.sqliteopenhelper.model.User

const val TABLE = "baza"
const val ID = "id"
const val NAME = "name"


class OfflineBaza(context: Context):SQLiteOpenHelper(context,"mybaze.db",null,1),Reja {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table $TABLE($ID integer primary key autoincrement unique not null,$NAME text not null)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun addUser(user: User) {
        val writer = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME,user.name)
        writer.insert(TABLE,null,contentValues)
        writer.close()
    }

    override fun getAllUser(): ArrayList<User> {
        val bazadanoqibolish = this.readableDatabase
        val list = ArrayList<User>()
        val query = "select * from $TABLE"
        val cursor = bazadanoqibolish.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val user = User(cursor.getInt(0),cursor.getString(1))
                list.add(user)
            }while (cursor.moveToNext())
        }
        return list
    }

}