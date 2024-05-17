package com.cazulabs.mylogin.checkUser.domain

import com.cazulabs.mylogin.checkUser.data.network.CheckUserService
import javax.inject.Inject

class CheckUserPhoneExistsUseCase @Inject constructor(private val api: CheckUserService) {

    suspend operator fun invoke(phone: String): Boolean {
        return api.checkUserPhone(phone)
    }

}