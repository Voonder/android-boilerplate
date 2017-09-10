/*
 * Copyright (c) 2017 Voonder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.voonapp.boilerplate.cache

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Singleton

@Singleton
object PreferenceHelper {

  fun defaultPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

  fun customPrefs(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

  inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
  }

  /**
   * Puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
   *
   * @param key the preferences key
   * @param value the value to save
   */
  operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
      is String? -> edit { it.putString(key, value) }
      is Set<*> -> edit { it.putStringSet(key, value.filterIsInstance<String>().toSet()) }
      is Int -> edit { it.putInt(key, value) }
      is Boolean -> edit { it.putBoolean(key, value) }
      is Float -> edit { it.putFloat(key, value) }
      is Long -> edit { it.putLong(key, value) }
      else -> throw UnsupportedOperationException("Not yet implemented.")
    }
  }

  /**
   * Finds value on given key. [T] is the type of value
   *
   * @param key the preferences key
   * @param defaultValue optional value - will take null for strings, false for bool and -1
   * for numeric values if [defaultValue] is not specified
   *
   * @return
   */
  operator inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
    return when (T::class) {
      String::class -> getString(key, defaultValue as? String) as T?
      Set::class -> getStringSet(key, defaultValue as? Set<String>? ?: setOf<String>()) as T?
      Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
      Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
      Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
      Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
      else -> throw UnsupportedOperationException("Not yet implemented.")
    }
  }
}
