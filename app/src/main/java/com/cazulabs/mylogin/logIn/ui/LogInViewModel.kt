package com.cazulabs.mylogin.logIn.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData("")
    val phone: LiveData<String> = _phone

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    fun onLogInChanged(
        email: String = _email.value!!,
        phone: String = _phone.value!!,
        password: String = _password.value!!
    ) {
        _email.value = email
        _phone.value = phone
        _password.value = password

        enableLogIn(email, phone, password)
    }

    private fun enableLogIn(email: String, phone: String, password: String) {
        //TODO manage logIn button enable
    }

}