package com.runtimeenabled.algosdk.transaction.sdk

import com.runtimeenabled.algosdk.domain.model.Algo25Account

interface AlgoAccountSdk {

    fun createAlgo25Account(): Algo25Account?

    fun recoverAlgo25Account(mnemonic: String): Algo25Account?

    fun getMnemonicFromAlgo25SecretKey(secretKey: ByteArray): String?
}
