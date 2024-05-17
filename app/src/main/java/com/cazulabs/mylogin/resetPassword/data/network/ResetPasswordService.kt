package com.cazulabs.mylogin.resetPassword.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ResetPasswordService @Inject constructor(private val resetPasswordClient: ResetPasswordClient) {

    suspend fun onResetPassword(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = resetPasswordClient.onResetPassword(/*email, password*/)
            response.body()?.success ?: false
        }
    }

}