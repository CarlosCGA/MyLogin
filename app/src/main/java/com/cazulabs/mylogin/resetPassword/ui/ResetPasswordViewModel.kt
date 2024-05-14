package com.cazulabs.mylogin.resetPassword.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _isResetPasswordEnabled = MutableLiveData<Boolean>()
    val isResetPasswordEnabled: LiveData<Boolean> = _isResetPasswordEnabled

    fun onResetPasswordChange(email: String, password: String, confirmPassword: String) {
        _email.value = email
        _password.value = password
        _confirmPassword.value = confirmPassword

        enableResetPassword(email, password, confirmPassword)
    }

    private fun enableResetPassword(email: String, password: String, confirmPassword: String) {
        _isResetPasswordEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && password.isNotBlank()
                    && password == confirmPassword
    }
}