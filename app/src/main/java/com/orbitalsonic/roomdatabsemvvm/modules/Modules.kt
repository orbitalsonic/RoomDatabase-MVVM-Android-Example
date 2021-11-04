package com.orbitalsonic.roomdatabsemvvm.modules

import com.orbitalsonic.roomdatabsemvvm.repository.UserRepository
import com.orbitalsonic.roomdatabsemvvm.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

    single { UserRepository(get()) }

    viewModel { UserViewModel(get()) }

}