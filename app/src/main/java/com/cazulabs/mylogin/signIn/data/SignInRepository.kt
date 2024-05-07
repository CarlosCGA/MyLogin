package com.cazulabs.mylogin.signIn.data

import com.cazulabs.mylogin.signIn.data.network.SignInService
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: SignInService){

    suspend fun doSignIn(email: String, phone: String, password: String): Boolean {
        return api.doSignIn(email, phone, password)
    }

}