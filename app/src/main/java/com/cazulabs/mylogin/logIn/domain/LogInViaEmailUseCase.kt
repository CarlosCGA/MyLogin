package com.cazulabs.mylogin.logIn.domain

import com.cazulabs.mylogin.logIn.data.LogInRepository
import javax.inject.Inject

class LogInViaEmailUseCase @Inject constructor(private val repository: LogInRepository) {

    suspend operator fun invoke(email: String, password: String): Boolean {
        return repository.doLogInViaEmail(email, password)
    }
}