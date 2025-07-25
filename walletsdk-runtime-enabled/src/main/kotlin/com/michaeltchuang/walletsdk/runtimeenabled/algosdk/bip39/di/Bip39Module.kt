package com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.di

import com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.sdk.AlgorandBip39WalletProvider
import com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.sdk.Bip39WalletProvider
import org.koin.dsl.module

val bip39Module = module {
    single<Bip39WalletProvider> { AlgorandBip39WalletProvider() }
}
