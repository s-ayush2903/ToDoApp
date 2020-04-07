package com.prudhvir3ddy.todo_app_gettingthingsdone.storage

import android.content.Context
import android.content.SharedPreferences
import com.prudhvir3ddy.todo_app_gettingthingsdone.storage.SharedPrefs.PREFS_CONSTANTS.FULL_NAME
import com.prudhvir3ddy.todo_app_gettingthingsdone.storage.SharedPrefs.PREFS_CONSTANTS.IS_LOGGED_IN
import com.prudhvir3ddy.todo_app_gettingthingsdone.storage.SharedPrefs.PREFS_CONSTANTS.TODO_APP_PREFS

class SharedPrefs(context: Context) {

  object PREFS_CONSTANTS {
    const val TODO_APP_PREFS = "todoAppPrefs"
    const val IS_LOGGED_IN = "isLoggedIn"
    const val FULL_NAME = "fullName"
  }

  private val sharedPreferences: SharedPreferences =
    context.getSharedPreferences(TODO_APP_PREFS, Context.MODE_PRIVATE)

  private val editor: SharedPreferences.Editor = sharedPreferences.edit()

  fun setLogin(login: Boolean) {
    editor.putBoolean(IS_LOGGED_IN, login)
    editor.commit()
  }

  fun setFullName(fullName: String) {
    editor.putString(FULL_NAME, fullName)
  }

  fun getFullName(): String {
    return sharedPreferences.getString(FULL_NAME, null) ?: "boo"
  }

  fun getLogin(): Boolean {
    return sharedPreferences.getBoolean(IS_LOGGED_IN, false)
  }

}