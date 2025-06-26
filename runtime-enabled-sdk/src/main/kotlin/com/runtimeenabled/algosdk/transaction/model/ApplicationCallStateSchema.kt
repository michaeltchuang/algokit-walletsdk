package com.runtimeenabled.algosdk.transaction.model

import java.math.BigInteger

data class ApplicationCallStateSchema(
    val numberOfInts: BigInteger?,
    val numberOfBytes: BigInteger?
)
