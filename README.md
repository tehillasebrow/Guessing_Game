# Guessing Game 🎲

A native Android application where the user attempts to guess a randomly generated number. While the game logic is simple, the project was built to demonstrate robust **Android Lifecycle** handling.

## 📱 Technical Highlights
* **Lifecycle Management:**
    * Implements `onSaveInstanceState` to preserve the secret number during configuration changes (screen rotation).
    * Prevents the frustrating user experience of the game resetting itself accidentally.
* **JSON Serialization:** Uses the **Gson** library to serialize the Game Object state for storage.
* **View Binding:** Uses Android Jetpack ViewBinding for type-safe interaction with UI elements.

## 🛠️ Tech Stack
* **Language:** Java, Android SDK
* **Libraries:** Google Gson
* **Architecture:** Separation of Model and UI logic.

 <img width="720" height="1604" alt="Screenshot_20250731_005247" src="https://github.com/user-attachments/assets/a8aafbe0-5437-4db6-8323-c3abdb503428" />
