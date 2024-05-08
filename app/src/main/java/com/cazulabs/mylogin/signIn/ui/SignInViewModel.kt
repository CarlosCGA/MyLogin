package com.cazulabs.mylogin.signIn.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cazulabs.mylogin.signIn.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

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
        username: String,
        email: String,
        phone: String,
        password: String
    ) {
        _username.value = username
        _email.value = email
        _phone.value = phone
        _password.value = password

        enableLogIn(email, phone, password)
    }

    /**
     * Conditions of input signIn
     */
    private fun enableLogIn(email: String, phone: String, password: String) {
        _isLogInEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && Patterns.PHONE.matcher(phone).matches()
                    && password.isNotBlank()
                    && password.isNotEmpty()
    }

    /**
     * Do logIn method
     */
    fun onSignIn() {
        viewModelScope.launch {

            val result = signInUseCase(email.value!!, phone.value!!, password.value!!)

            if(result)
                Log.i("CARLOS", "GO IN!")

        }
    }


}