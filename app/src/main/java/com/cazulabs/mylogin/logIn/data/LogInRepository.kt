package com.cazulabs.mylogin.logIn.data

import com.cazulabs.mylogin.logIn.data.network.LogInService
import javax.inject.Inject

class LogInRepository @Inject constructor(private val api: LogInService) {

    suspend fun doLogInViaEmail(email: String, password: String): Boolean {
        return api.doLogInViaEmail(email, password)
    }

    suspend fun doLogInViaPhone(phone: String, password: String): Boolean {
        return api.doLogInViaEmail(phone, password)
    }

}