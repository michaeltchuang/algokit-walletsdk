package com.michaeltchuang.walletsdk.runtimeenabled.algosdk.transaction.sdk.model

import java.math.BigInteger

data class AssetTransactionPayload(
    val senderAddress: String,
    val receiverAddress: String,
    val amount: BigInteger,
    val assetId: Long,
    val noteInByteArray: ByteArray?
)
