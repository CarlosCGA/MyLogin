package com.cazulabs.mylogin.logIn.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LogInService @Inject constructor(private val logInClient: LogInClient) {

    suspend fun doLogIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = logInClient.doLogIn(user, password)
            response.body()?.success ?: false //If null return false
        }
    }

}