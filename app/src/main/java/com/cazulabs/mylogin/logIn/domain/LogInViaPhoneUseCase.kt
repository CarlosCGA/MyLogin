package com.cazulabs.mylogin.logIn.domain

import com.cazulabs.mylogin.logIn.data.LogInRepository
import javax.inject.Inject

class LogInViaPhoneUseCase @Inject constructor(private val repository: LogInRepository) {

    suspend operator fun invoke(phone: String, password: String): Boolean {
        return repository.doLogInViaPhone(phone, password)
    }
}