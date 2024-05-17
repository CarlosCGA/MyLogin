package com.cazulabs.mylogin.checkUser.domain

import com.cazulabs.mylogin.checkUser.data.network.CheckUserService
import javax.inject.Inject

class CheckUserEmailExistsUseCase @Inject constructor(private val api: CheckUserService) {

    suspend operator fun invoke(email: String): Boolean {
        return api.checkUserEmail(email)
    }

}