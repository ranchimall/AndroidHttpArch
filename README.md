# Android HTTP Architecture

Android Studios project to open local HTML files in Chrome Custom Tab by hosting local HTTP server using NanoHTTPD.

### User Requirements
- Android >= 7.0 (Nougat)
- Android Chrome browser app

## Prerequisite

### Android Studio
Android Studio is required for building the APK from the source code
- Download and Install Android Studio from the official [site](https://developer.android.com/studio)

### Android SDK
Android SDK (Software Development Kit) contains the required libraries and tools to build the APK

#### Install Android SDK
1. Open Android Studio (for the first time after installation) and SDK installation will pop up.
2. Select the installation directory for Andriod SDK.
3. Click continue and accept to install Andriod SDK.

#### Install required SDK platform
1. Open Android Studio
2. In menu bar click, `Tools` -> `SDK Manager`.
3. A window will pop up with the list of Android versions available.
4. To install any version, click the checkbox `☐` near the Android Name and click `Apply`. 
    - Select checkbox `☑` of `Android 7.0 Nougat` and click `Apply`.
5. Upon successful installation, the `Status` will be changed to `Installed`.

## Building APK

1. Clone/Download this github repo
2. Copy any webpage files (html, js, css, svg, images, etc) of your project to the `asset` folder (path: `AndroidHttpArch/app/src/main/assets/`)
    - AndroidHttpArch
        - app
            - src
                - main
                    - assets
3. Open `AndroidHttpArch` folder in Android Studio
    - In Android Studio menubar: Click `File` -> `Open`. Navigate and select `AndroidHttpArch` folder. Click `Ok`.
4. Edit port and home page in `MainActivity.java`. (path: `AndroidHttpArch/app/src/main/java/com/ranchimall/androidhttparch/MainActivity.java`)
    - Line 16: Edit port (for local hosting).
    - Line 17: Edit the starting home page link. (Most projects have `index.html` or `home.html` as starting homepage)
5. Select Build variant
    - Click `Build` -> `Select Build Variant`. The `Build Variant` panel will open/pop-up
    - For `Module`: `app`, select `Active Build Variant` as `release` 
5. Build the project
    - Click `Build` -> `Make Project`. (Default windows shortcut: `Ctrl`+`F9`).
6. Wait for the build process to complete. (A pop up will appear at the bottom upon build completion)
7. APK file will be generated in the `apk` folder. (path: `AndroidHttpArch/app/build/outputs/apk/`)
    - AndroidHttpArch
        - app
            - build
                - outputs
                    - apk
                    
The APK file can be distrubuted to users for installing in their Android devices.
