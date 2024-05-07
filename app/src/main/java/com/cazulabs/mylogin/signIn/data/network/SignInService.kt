package com.cazulabs.mylogin.signIn.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInService @Inject constructor(private val signInClient: SignInClient) {

    suspend fun doSignIn(email: String, phone: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = signInClient.doSignIn(/*email, phone, password*/)
            response.body()?.success ?: false //If null return false
        }
    }

}