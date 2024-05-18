package com.cazulabs.mylogin.logIn.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LogInService @Inject constructor(private val logInClient: LogInClient) {

    suspend fun doLogInViaEmail(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = logInClient.doLogInViaEmail(/*user, password*/)
            response.body()?.success ?: false //If null return false
        }
    }

    suspend fun doLogInViaPhone(phone: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = logInClient.doLogInViaPhone(/*user, password*/)
            response.body()?.success ?: false //If null return false
        }
    }

}