package com.cazulabs.mylogin.signIn.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cazulabs.mylogin.countriesInformation.domain.GetCountriesPhonePrefixFlowUseCase
import com.cazulabs.mylogin.countriesInformation.domain.InsertCountriesInformationUseCase
import com.cazulabs.mylogin.countriesInformation.ui.CountriesPhonePrefixUiState
import com.cazulabs.mylogin.countriesInformation.ui.CountriesPhonePrefixUiState.Success
import com.cazulabs.mylogin.signIn.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val insertCountriesInformationUseCase: InsertCountriesInformationUseCase,
    getCountriesPhonePrefixUseCase: GetCountriesPhonePrefixFlowUseCase
) : ViewModel() {

    val uiState: StateFlow<CountriesPhonePrefixUiState> =
        getCountriesPhonePrefixUseCase().map(::Success)
            .catch { Error(it) }
            .stateIn(
                viewModelScope, SharingStarted.WhileSubscribed(5000),
                CountriesPhonePrefixUiState.Loading
            )

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _phonePrefix = MutableLiveData<String>()
    val phonePrefix: LiveData<String> = _phonePrefix

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _isSignInEnabled = MutableLiveData<Boolean>()
    val isSignInEnabled: LiveData<Boolean> = _isSignInEnabled

    fun insertCountriesInformation() {
        viewModelScope.launch {
            insertCountriesInformationUseCase()
        }
    }

    /**
     * Update viewModel variables when updated in input textFields
     */
    fun onSignInChanged(
        username: String,
        email: String,
        phonePrefix: String,
        phone: String,
        password: String,
        confirmPassword: String
    ) {
        _username.value = username
        _email.value = email
        _phonePrefix.value = phonePrefix
        _phone.value = phone
        _password.value = password
        _confirmPassword.value = confirmPassword

        enableSignIn(email, phone, password, confirmPassword)
    }

    /**
     * Conditions of input signIn
     */
    private fun enableSignIn(
        email: String,
        phone: String,
        password: String,
        confirmPassword: String
    ) {
        _isSignInEnabled.value =
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && Patterns.PHONE.matcher(phone).matches()
                    && password.isNotBlank()
                    && password.isNotEmpty()
                    && password == confirmPassword
    }

    /**
     * Do logIn method
     */
    fun onSignIn() {
        viewModelScope.launch {

            val result =
                signInUseCase(username.value!!, email.value!!, phone.value!!, password.value!!)

            if (result)
                Log.i("CARLOS", "GO IN!")

        }
    }


}