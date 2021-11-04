package com.orbitalsonic.roomdatabsemvvm.modules

import androidx.room.Room
import com.orbitalsonic.roomdatabsemvvm.MainApplication
import com.orbitalsonic.roomdatabsemvvm.database.UserDatabase
import com.orbitalsonic.roomdatabsemvvm.repository.UserRepository
import com.orbitalsonic.roomdatabsemvvm.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

    single {
        Room.databaseBuilder(
            androidApplication(),
            UserDatabase::class.java,
            "user_data_databases"
        ).build()
    }

    single {
        val database = get<UserDatabase>()
        database.userDao()
    }

    single { UserRepository(get()) }

    viewModel { UserViewModel(get()) }


}