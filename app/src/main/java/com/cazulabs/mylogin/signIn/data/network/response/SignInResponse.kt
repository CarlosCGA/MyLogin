package com.cazulabs.mylogin.signIn.data.network.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(@SerializedName("success") val success: Boolean)
