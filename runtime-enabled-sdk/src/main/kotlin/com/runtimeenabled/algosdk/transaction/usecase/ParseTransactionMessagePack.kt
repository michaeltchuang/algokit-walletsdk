package com.runtimeenabled.algosdk.transaction.usecase

import com.runtimeenabled.algosdk.transaction.model.RawTransaction

fun interface ParseTransactionMessagePack {
    operator fun invoke(txnByteArray: ByteArray): RawTransaction?
}
