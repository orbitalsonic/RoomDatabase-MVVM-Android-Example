package com.orbitalsonic.roomdatabsemvvm.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orbitalsonic.roomdatabsemvvm.datamodel.UserEntity

object ObjectConverter {


    fun fromObjectToString(mObject: UserEntity):String{
        return Gson().toJson(mObject)
    }

    fun fromStringToObject(mString:String): UserEntity {
        val noteType = object :TypeToken<UserEntity>(){}.type
        return Gson().fromJson(mString,noteType)
    }

}