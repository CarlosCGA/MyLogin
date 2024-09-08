# MyLogin - Android App ![Build status](https://github.com/wallabag/android-app/workflows/CI/badge.svg?branch=master)
<!-- TODO UPDATE TO CORRECT LINK -->

<img src="/assets/app-icon.png" align="center"
width="200" hspace="10" vspace="10">

MyLogin is a self-developed app that includes an initial base login.

<!--
[App] is available on the Google Play Store.

<p align="left">
<a href="https://play.google.com/store/apps/">
    <img alt="Get it on Google Play"
        height="80"
        src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" />
</a>  

        </p>
-->

## About

MyLogin is an Android application, fully developed by Carlos Cañete in Android Studio using the Android SDK.
This application is a creation from Carlos Cañete.

## Dependencies

- Retrofit: It facilitates the creation of HTTP clients to interact with REST APIs. It automatically converts API responses into objects, simplifying requests and data handling over the network within the application.
- DaggerHilt: It simplifies dependency injection by integrating Dagger with the Android components' lifecycle. Hilt automates the creation and management of dependencies, making configuration easier and improving development efficiency in Android.

## Architecture - MVVM (Model-View-ViewModel)

This architecture facilitates the separation of concerns, enhancing code maintainability and scalability by dividing it into three main components:

- Model: It manages the application's data and business logic.
- View: It represents the user interface and displays the data from the ViewModel.
- ViewModel: It acts as an intermediary between the Model and the View, managing presentation logic and updating the UI.

## Screenshots
<!--[In progress...]-->

[<img src="/assets/LogInPhoneFilled.jpg" align="right"
width="200">](/assets/LogInPhoneFilled.jpg)

[<img src="/assets/LogInPhone.jpg" align="right"
width="200">](/assets/LogInPhone.jpg)

[<img src="/assets/LogInEmail.jpg" align="left"
width="200">](/assets/LogInEmail.jpg)

[<img src="/assets/LogInEmailFilled.jpg" align="center"
width="200">](/assets/LogInEmailFilled.jpg)

[<img src="/assets/HelloWorld.jpg" align="right"
width="200">](/assets/HelloWorld.jpg)

[<img src="/assets/SignIn.jpg" align="right"
width="200">](/assets/SignIn.jpg)

[<img src="/assets/ResetPasswordEmail.jpg" align="left"
width="200">](/assets/ResetPasswordEmail.jpg)

[<img src="/assets/ResetPasswordPhone.jpg" align="center"
width="200">](/assets/ResetPasswordPhone.jpg)


## Contributing

You can help the project by reporting bugs and making suggestions [here](https://github.com/CarlosCGA/myLogin/issues).
