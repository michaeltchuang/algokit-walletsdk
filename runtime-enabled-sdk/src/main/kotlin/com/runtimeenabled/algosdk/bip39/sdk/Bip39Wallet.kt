package com.runtimeenabled.algosdk.bip39.sdk

import com.runtimeenabled.algosdk.bip39.model.Bip39Entropy
import com.runtimeenabled.algosdk.bip39.model.Bip39Mnemonic
import com.runtimeenabled.algosdk.bip39.model.Bip39Seed
import com.runtimeenabled.algosdk.bip39.model.HdKeyAddress
import com.runtimeenabled.algosdk.bip39.model.HdKeyAddressIndex
import com.runtimeenabled.algosdk.bip39.model.HdKeyAddressLite

interface Bip39Wallet {
    fun getEntropy(): Bip39Entropy
    fun getSeed(): Bip39Seed
    fun getMnemonic(): Bip39Mnemonic
    fun generateAddress(index: HdKeyAddressIndex): HdKeyAddress
    fun generateAddressLite(index: HdKeyAddressIndex): HdKeyAddressLite
    fun invalidate()
}
