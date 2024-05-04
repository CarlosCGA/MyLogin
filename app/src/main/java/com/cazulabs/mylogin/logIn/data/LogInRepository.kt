package com.cazulabs.mylogin.logIn.data

import com.cazulabs.mylogin.logIn.data.network.LogInService
import javax.inject.Inject

class LogInRepository @Inject constructor(private val api: LogInService) {

    suspend fun doLogIn(user: String, password: String): Boolean {
        return api.doLogIn(user, password)
    }

}