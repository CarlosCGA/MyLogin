package com.cazulabs.mylogin.signIn.data

import com.cazulabs.mylogin.signIn.data.network.SignInService
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: SignInService){

    suspend fun doSignIn(user: String, phone: String, password: String): Boolean {
        return api.doSignIn(user, phone, password)
    }

}