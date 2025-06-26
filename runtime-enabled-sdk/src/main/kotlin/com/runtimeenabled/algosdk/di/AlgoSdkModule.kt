package com.runtimeenabled.algosdk.di

import com.runtimeenabled.algosdk.domain.usecase.RecoverWithPassphrasePreviewUseCase
import com.runtimeenabled.algosdk.transaction.sdk.AlgoAccountSdkImpl
import com.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39Sdk
import com.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39SdkImpl
import org.koin.dsl.module

val algoSdkModule = module {
    single { AlgoAccountSdkImpl() }
    single<AlgoKitBip39Sdk> { AlgoKitBip39SdkImpl() }
    factory { RecoverWithPassphrasePreviewUseCase(get()) }
}

