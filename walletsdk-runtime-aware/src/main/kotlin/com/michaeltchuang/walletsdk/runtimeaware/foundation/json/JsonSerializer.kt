package com.michaeltchuang.walletsdk.runtimeaware.foundation.json

interface JsonSerializer {
    fun toJson(payload: Any?): String
    fun <T> fromJson(json: String, type: Class<T>): T?
}
