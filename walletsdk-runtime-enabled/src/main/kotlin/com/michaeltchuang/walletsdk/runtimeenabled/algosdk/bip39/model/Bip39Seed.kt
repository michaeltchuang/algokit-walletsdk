package com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.model

data class Bip39Seed internal constructor(val value: ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bip39Seed

        return value.contentEquals(other.value)
    }

    override fun hashCode(): Int {
        return value.contentHashCode()
    }
}
