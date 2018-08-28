# Firebase-Real-Database-Dagger2-Retrofit-Rxjava-Kotlin
Sample applicarion to demonstrate how to use Firebase Databae

Prerequisites
--------------
- minSdkVersion 19
- targetSdkVersion 28
- Latest Android Build Tools
- Android Support Repository
- Dagger (Depedency Injection)
- Retrofit
- RxAndroid

Firebase Project Creation
-------------------------
Create project in [Firebase Console](https://console.firebase.google.com/) and enable the Firebase Real Database.<br />
Register a android project using following setps<br />
- Project Overview -> project settings -> Add App<br />
- Download the google-services.json<br />
- Add the file into App folder in project<br />

User Authentication
-------------------
From Firebase console select 'Authentication' from Develop section <br />
Under the Sign-in-method tab enable the Email/Password method.

Database Creation
-----------------
This is a very simple step <br />
From Firebase console select Database and create new test database for test purpose.

Database Rule
-------------
Database Rule writting is critical task in Firebase DB. This sample application works on following DB rule<br />
User data are only readable/writable by the user who owns it.<br />
auth.uid == $UID line authenticate the user.

{
  "rules": {
    "users": {
      "$UID": {
        ".read": "auth.uid == $UID",
        ".write": "auth.uid == $UID"
      }
    }
}
}


## Architecture Pattern
The application make use of MPV architecture pattern.

## License
Please see the [LICENSE.md](https://github.com/SinoKD/Firebase-Real-Database-Dagger2-Retrofit-Rxjava-Kotlin/blob/master/LICENSE) file for details
