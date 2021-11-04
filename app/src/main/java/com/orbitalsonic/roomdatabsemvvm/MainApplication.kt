package com.orbitalsonic.roomdatabsemvvm

import android.app.Application
import com.orbitalsonic.roomdatabsemvvm.database.UserDatabase
import com.orbitalsonic.roomdatabsemvvm.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainApplication:Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { UserDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(database.userDao()) }
}