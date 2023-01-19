package com.android.tripapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBMemberInfo (
    context : Context,
    name : String?,
    factory : SQLiteDatabase.CursorFactory?,
    version : Int
) : SQLiteOpenHelper (context, name, factory, version) {
    override fun onCreate(db : SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE member_info(email text, password text, birth text, nickname text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}