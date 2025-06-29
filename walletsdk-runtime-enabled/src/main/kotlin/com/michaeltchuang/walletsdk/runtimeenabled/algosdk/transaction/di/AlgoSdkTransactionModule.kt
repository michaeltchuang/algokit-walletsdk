package com.michaeltchuang.walletsdk.runtimeenabled.algosdk.transaction.di

import com.michaeltchuang.walletsdk.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39Sdk
import com.michaeltchuang.walletsdk.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39SdkImpl
import org.koin.dsl.module

val algoSdkTransactionModule = module {
    single { AlgoKitBip39SdkImpl() }
    single<AlgoKitBip39Sdk> { AlgoKitBip39SdkImpl() }
}
