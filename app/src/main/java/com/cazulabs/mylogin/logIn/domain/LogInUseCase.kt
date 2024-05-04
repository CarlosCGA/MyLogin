package com.cazulabs.mylogin.logIn.domain

import com.cazulabs.mylogin.logIn.data.LogInRepository
import javax.inject.Inject

class LogInUseCase @Inject constructor(private val repository: LogInRepository) {

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogIn(user, password)
    }
}