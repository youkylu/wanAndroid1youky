package com.wanAndroid.datastore.usecase

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun <T> getValue(key: String, defaultValue: T): T
    suspend fun <T> setValue(key: String, value: T)
    fun <T> getValueFlow(key: String, defaultValue: T): Flow<T>
}