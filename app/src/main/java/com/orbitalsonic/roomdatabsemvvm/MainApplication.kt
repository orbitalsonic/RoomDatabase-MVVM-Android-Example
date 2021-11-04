package com.orbitalsonic.roomdatabsemvvm

import android.app.Application
import com.orbitalsonic.roomdatabsemvvm.database.UserDatabase
import com.orbitalsonic.roomdatabsemvvm.modules.appModule
import com.orbitalsonic.roomdatabsemvvm.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication:Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { UserDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(database.userDao()) }

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MainApplication)
            modules(listOf(appModule))
        }
    }
}