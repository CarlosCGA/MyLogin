package com.cazulabs.mylogin.resetPassword.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ResetPasswordService @Inject constructor(private val resetPasswordClient: ResetPasswordClient) {

    suspend fun onResetPasswordViaEmail(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = resetPasswordClient.onResetPasswordViaEmail(/*email, password*/)
            response.body()?.success ?: false
        }
    }

    suspend fun onResetPasswordViaPhone(phone: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = resetPasswordClient.onResetPasswordViaPhone(/*phone, password*/)
            response.body()?.success ?: false
        }
    }

}