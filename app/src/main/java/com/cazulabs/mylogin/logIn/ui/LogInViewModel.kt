package com.cazulabs.mylogin.logIn.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cazulabs.mylogin.logIn.domain.LogInViaEmailUseCase
import com.cazulabs.mylogin.logIn.domain.LogInViaPhoneUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val logInViaEmailUseCase: LogInViaEmailUseCase,
    private val logInViaPhoneUseCase: LogInViaPhoneUseCase
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLogInEnabled = MutableLiveData<Boolean>()
    val isLogInEnabled: LiveData<Boolean> = _isLogInEnabled

    private val _isLogInEmailMode = MutableLiveData<Boolean>()
    val isLogInEmailMode: LiveData<Boolean> = _isLogInEmailMode

    /**
     * Update viewModel variables when updated in input textFields
     */
    fun onLogInChanged(
        email: String,
        phone: String,
        password: String,
        isLogInEmailMode: Boolean
    ) {
        _email.value = email
        _phone.value = phone
        _password.value = password
        _isLogInEmailMode.value = isLogInEmailMode

        if (isLogInEmailMode)
            enableLogInViaEmail(email = email, password = password)
        else
            enableLogInViaPhone(phone = phone, password = password)
    }

    /**
     * Conditions of input logIn via email to enable logIn button
     */
    private fun enableLogInViaEmail(email: String, password: String) {
        _isLogInEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && password.isNotBlank()
                    && password.isNotEmpty()
    }

    /**
     * Conditions of input logIn via phone to enable logIn button
     */
    private fun enableLogInViaPhone(phone: String, password: String) {
        _isLogInEnabled.value =
            Patterns.PHONE.matcher(phone).matches()
                    && password.isNotBlank()
                    && password.isNotEmpty()
    }

    /**
     * Do logIn method
     */
    fun onLogIn(): Boolean {
        viewModelScope.launch {
            val result = if (isLogInEmailMode.value!!)
                logInViaEmailUseCase(email.value!!, password.value!!)
            else
                logInViaPhoneUseCase(phone.value!!, password.value!!)

            if (result) {
                Log.i("CARLOS", "GO IN!")
            }
        }

        //TODO WAIT AND MANAGE RESULT
        return true
    }

}