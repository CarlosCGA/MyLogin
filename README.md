# MyLogin - Android App

<p align="center">
    <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp" alt="App icon" width="50"/>
    <br />
    <b>MyLogin is a self-developed app that includes an initial base login</b>
    <br />
    <br />
    <img src="https://github.com/CarlosCGA/MyLogin/actions/workflows/android.yml/badge.svg" alt="CI badge sign" />
</p>

## About

MyLogin is an Android application, fully developed by Carlos Cañete in Android Studio using the Android SDK.
This application is a creation from Carlos Cañete.


## Layout - Jetpack Compose

Modern UI toolkit for building native Android apps using a declarative approach. It simplifies UI development by allowing developers to define how the UI should look directly in code, rather than using XML. It's used to create responsive and dynamic user interfaces more efficiently.


## Dependencies

- `Retrofit`: Facilitates the creation of HTTP clients to interact with REST APIs. It automatically converts API responses into objects, simplifying requests and data handling over the network within the application (in this case, helped through GSON library).
- `GSON`: Facilitates JSON serialization and deserialization by converting JSON data to Kotlin/Java objects and vice versa. It simplifies API integration by automatically mapping JSON responses to data models. Lightweight and efficient, it handles nested objects and complex data structures seamlessly.
- `ROOM`: Provides a robust SQLite abstraction, allowing developers to create and manage databases with type safety and compile-time verification of SQL queries. It supports annotations to define entities, DAOs, and database schemas, reducing boilerplate code. Integrated with LiveData and Flow, Room enables seamless reactive data updates in MVVM architectures.
- `LiveData`: Android Architecture Component that allows UI components to observe data changes while respecting their lifecycle, preventing memory leaks and crashes. It updates observers automatically, simplifying reactive UI patterns in MVVM architecture. MutableLiveData enables data updates, while LiveData ensures read-only access from the UI.
- `DaggerHilt`: Simplifies dependency injection by integrating Dagger with the Android components' lifecycle. Hilt automates the creation and management of dependencies, making configuration easier and improving development efficiency in Android.
- `Navigation`: Simplifies in-app navigation, managing fragment and activity transitions, and handling complex navigation flows. It enables safe argument passing between destinations and offers features like deep linking and back stack management. Designed for modularity, Navigation integrates seamlessly with ViewModel and LiveData in an MVVM architecture.
- `Material Icons`: Provides an expanded set of Material Design icons for use in Jetpack Compose, covering a wide range of categories like navigation and communication. It allows easy integration of consistent, ready-to-use icons without external assets.


## Architecture - MVVM (Model-View-ViewModel)

This architecture facilitates the separation of concerns, enhancing code maintainability and scalability by dividing it into three main components:

- Model: It manages the application's data and business logic.
- View: It represents the user interface and displays the data from the ViewModel.
- ViewModel: It acts as an intermediary between the Model and the View, managing presentation logic and updating the UI.

## Screenshots

<p align="center">
    <img src="/assets/LogInEmail.jpg" alt="LogIn via email" width="200"/>
    <img src="/assets/LogInEmailFilled.jpg" alt="LogIn via email filled" width="200"/>
    <img src="/assets/LogInPhone.jpg" alt="LogIn via phone" width="200"/>
    <img src="/assets/LogInPhoneFilled.jpg" alt="LogIn via phone filled" width="200"/>
    <img src="/assets/ResetPasswordEmail.jpg" alt="Reset password via phone" width="200"/>
     <img src="/assets/ResetPasswordPhone.jpg" alt="Reset password via phone" width="200"/>
    <img src="/assets/SignIn.jpg" alt="SignIn" width="200"/>
    <img src="/assets/HelloWorld.jpg" alt="LogIn successful" width="200"/>
</p>


## Contributing

You can help the project by reporting bugs and making suggestions [here](https://github.com/CarlosCGA/myLogin/issues).

#### ⚠️Disclaimer
API has been generated in [Mocky](https://designer.mocky.io/) (a free web where you can mock your endpoints), these endpoints after a while can disappear automatically and without notice, so the application in some cases may not work as designed. In any case this should not result in an unexpected crash.
