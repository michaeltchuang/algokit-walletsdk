package com.runtimeenabled.encryption.data.manager

import com.runtimeenabled.encryption.domain.manager.Base64Manager
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

internal class Base64ManagerImpl : Base64Manager {

    @OptIn(ExperimentalEncodingApi::class)
    override fun encode(byteArray: ByteArray): String {
        return Base64.encode(byteArray)
    }

    @OptIn(ExperimentalEncodingApi::class)
    override fun decode(value: String): ByteArray {
        return Base64.decode(value)
    }

    @OptIn(ExperimentalEncodingApi::class)
    override fun decode(value: String, flags: Int): ByteArray {
        return Base64.decode(value, flags)
    }
}
