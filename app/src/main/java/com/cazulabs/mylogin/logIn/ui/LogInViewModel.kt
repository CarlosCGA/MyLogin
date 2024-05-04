package com.cazulabs.mylogin.logIn.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLogInEnabled = MutableLiveData<Boolean>()
    val isLogInEnabled: LiveData<Boolean> = _isLogInEnabled

    /**
     * Update viewModel variables when updated in input textFields
     */
    fun onLogInChanged(
        email: String,
        phone: String,
        password: String
    ) {
        _email.value = email
        _phone.value = phone
        _password.value = password

        enableLogIn(email, phone, password)
    }

    /**
     * Conditions of input logIn to enable logIn button
     */
    private fun enableLogIn(email: String, phone: String, password: String) {
        _isLogInEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && Patterns.PHONE.matcher(phone).matches()
                    && password.isNotBlank()
                    && password.isNotEmpty()
    }

}