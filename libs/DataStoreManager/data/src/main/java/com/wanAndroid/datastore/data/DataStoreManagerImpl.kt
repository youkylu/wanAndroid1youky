package com.wanAndroid.datastore.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.wanAndroid.datastore.usecase.DataStoreManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStoreManagerImpl(context:Context) :DataStoreManager{
    companion object {
        private const val SH_DATASTORE_PREFERENCES = "SH_DATASTORE_PREFERENCES"
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SH_DATASTORE_PREFERENCES)
    }

    private val dataStore = context.dataStore

    override suspend fun <T> getValue(key: String, defaultValue: T): T = when (defaultValue) {
        is Boolean -> {
            val datastoreKey = booleanPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        is Int -> {
            val datastoreKey = intPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        is Float -> {
            val datastoreKey = floatPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        is Long -> {
            val datastoreKey = longPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        is String -> {
            val datastoreKey = stringPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        is Double -> {
            val datastoreKey = doublePreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }.first()
        }

        else -> throw IllegalArgumentException("This type does not be supported")
    } as T

    override suspend fun <T> setValue(key: String, value: T) {
        when (value) {
            is Boolean -> {
                val datastoreKey = booleanPreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            is Float -> {
                val datastoreKey = floatPreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            is Int -> {
                val datastoreKey = intPreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            is Long -> {
                val datastoreKey = longPreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            is String -> {
                val datastoreKey = stringPreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            is Double -> {
                val datastoreKey = doublePreferencesKey(key)
                dataStore.edit { mutablePreferences ->
                    mutablePreferences[datastoreKey] = value
                }
            }

            else -> throw IllegalArgumentException("This type can be saved into DataStore")
        }
    }

    override fun <T> getValueFlow(key: String, defaultValue: T): Flow<T> = when (defaultValue) {
        is Boolean -> {
            val datastoreKey = booleanPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        is Int -> {
            val datastoreKey = intPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        is Float -> {
            val datastoreKey = floatPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        is Long -> {
            val datastoreKey = longPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        is String -> {
            val datastoreKey = stringPreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        is Double -> {
            val datastoreKey = doublePreferencesKey(key)
            dataStore.data.map {
                it[datastoreKey] ?: defaultValue
            }
        }

        else -> throw IllegalArgumentException("This type can be saved into DataStore")
    } as Flow<T>
}