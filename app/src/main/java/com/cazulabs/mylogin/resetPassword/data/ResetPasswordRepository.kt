package com.cazulabs.mylogin.resetPassword.data

import com.cazulabs.mylogin.resetPassword.data.network.ResetPasswordService
import javax.inject.Inject

class ResetPasswordRepository @Inject constructor(private val api: ResetPasswordService) {

    suspend fun onResetPassword(email: String, password: String): Boolean {
        return api.onResetPassword(email, password)
    }

}