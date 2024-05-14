package com.cazulabs.mylogin.resetPassword.domain

import com.cazulabs.mylogin.resetPassword.data.ResetPasswordRepository
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(private val repository: ResetPasswordRepository) {

    suspend operator fun invoke(): Boolean {
        return repository.onResetPassword()
    }

}