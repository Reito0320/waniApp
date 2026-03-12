package com.example.cat.storage

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(name = "user")

class UserDataStore(private val context: Context) {

    // localstorageのkeyを作成している。
    companion object {
        val USER_ID = intPreferencesKey("user_id")
        val USER_NAME = stringPreferencesKey("user_name")
    }

    suspend fun saveUser(id: Long, name: String) {
        // そのkeyに対してvalueをあてがっている。
        context.dataStore.edit {
            it[USER_ID] = id.toInt()
            it[USER_NAME] = name
        }
    }


    // 値を取り出す際の関数。　きっとこれを別ファイルで使い倒す。
    suspend fun getUserId(): Long? {
        val preferences = context.dataStore.data.first()
        return preferences[USER_ID]?.toLong()
    }

    suspend fun getUserName(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[USER_NAME]
    }
}