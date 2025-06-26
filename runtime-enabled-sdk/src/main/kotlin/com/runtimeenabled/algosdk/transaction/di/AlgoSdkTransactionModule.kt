package com.runtimeenabled.algosdk.transaction.di

import com.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39Sdk
import com.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39SdkImpl
import org.koin.dsl.module

val algoSdkTransactionModule = module {
    single { AlgoKitBip39SdkImpl() }
    single<AlgoKitBip39Sdk> { AlgoKitBip39SdkImpl() }
}
