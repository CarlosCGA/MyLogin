package com.cazulabs.mylogin.resetPassword.data

import com.cazulabs.mylogin.resetPassword.data.network.ResetPasswordService
import javax.inject.Inject

class ResetPasswordRepository @Inject constructor(private val api: ResetPasswordService) {

    suspend fun onResetPasswordViaEmail(email: String, password: String): Boolean {
        return api.onResetPasswordViaEmail(email, password)
    }

    suspend fun onResetPasswordViaPhone(phone: String, password: String): Boolean {
        return api.onResetPasswordViaPhone(phone, password)
    }

}