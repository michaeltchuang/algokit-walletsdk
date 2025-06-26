package com.runtimeenabled.algosdk.transaction.sdk

import com.runtimeenabled.algosdk.transaction.model.AlgorandAddress

interface AlgoSdkAddress {

    fun isValid(address: String): Boolean

    fun generateAddressFromPublicKey(publicKey: ByteArray): AlgorandAddress?

    fun generateAddressFromPublicKey(addressBase64: String): AlgorandAddress?
}
