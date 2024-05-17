package com.cazulabs.mylogin.resetPassword.domain

import com.cazulabs.mylogin.resetPassword.data.ResetPasswordRepository
import javax.inject.Inject

class ResetPasswordPhoneUseCase @Inject constructor(private val repository: ResetPasswordRepository) {

    suspend operator fun invoke(phone: String, password: String): Boolean {
        return repository.onResetPasswordViaPhone(phone, password)
    }

}