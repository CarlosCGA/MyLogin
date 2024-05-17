package com.cazulabs.mylogin.resetPassword.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cazulabs.mylogin.resetPassword.domain.ResetPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(private val resetPasswordUseCase: ResetPasswordUseCase) :
    ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _isResetPasswordEnabled = MutableLiveData<Boolean>()
    val isResetPasswordEnabled: LiveData<Boolean> = _isResetPasswordEnabled

    private val _isResetPasswordEmailMode = MutableLiveData<Boolean>()
    val isResetPasswordEmailMode: LiveData<Boolean> = _isResetPasswordEmailMode

    fun onResetPasswordChange(
        email: String,
        phone: String,
        password: String,
        confirmPassword: String,
        isResetPasswordEmailMode: Boolean
    ) {
        _email.value = email
        _phone.value = phone
        _password.value = password
        _confirmPassword.value = confirmPassword
        _isResetPasswordEmailMode.value = isResetPasswordEmailMode

        if (isResetPasswordEmailMode)
            enableResetPasswordEmail(email, password, confirmPassword)
        else
            enableResetPasswordPhone(phone, password, confirmPassword)
    }

    private fun enableResetPasswordEmail(
        email: String,
        password: String,
        confirmPassword: String
    ) {
        _isResetPasswordEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && password.isNotBlank()
                    && password == confirmPassword
    }

    private fun enableResetPasswordPhone(
        phone: String,
        password: String,
        confirmPassword: String
    ) {
        _isResetPasswordEnabled.value =
            Patterns.PHONE.matcher(phone).matches()
                    && password.isNotBlank()
                    && password == confirmPassword
    }

    fun onDoResetPassword() {
        viewModelScope.launch {
            resetPasswordUseCase(_email.value!!, _password.value!!)
        }
    }
}