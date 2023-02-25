# AppiumFramework

1. Clone this project
2. Refer Android Environment Setup.docx to setup Android SDK, Appium server and Appium inspector
3. Start appium server
4. Run/Debug configuration testng_android_app.xml to run android app tests
5. Run/Debug configuration testng_android_browser.xml to run tests on chrome browser on android device.

Note: Add VM arguments "--add-opens java.base/java.lang=ALL-UNNAMED" in eclipse run configuration as work around to execute the tests on Appium java client 8.3.0 and Java 17.
![image](https://user-images.githubusercontent.com/42565488/221368971-4edf2559-cfb0-48e1-8bab-56169800e47e.png)
