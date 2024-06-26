package com.cazulabs.mylogin.signIn.domain

import com.cazulabs.mylogin.signIn.data.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repository: SignInRepository){

    suspend operator fun invoke(username: String, email: String, phone: String, password: String): Boolean {
        return repository.doSignIn(username, email, phone, password)
    }

}