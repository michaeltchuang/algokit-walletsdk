package com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.sdk

import cash.z.ecc.android.bip39.Mnemonics
import com.michaeltchuang.walletsdk.runtimeenabled.algosdk.bip39.model.Bip39Entropy

internal class AlgorandBip39WalletProvider : Bip39WalletProvider {

    override fun getBip39Wallet(entropy: ByteArray): Bip39Wallet {
        return AlgorandBip39Wallet(Bip39Entropy(entropy))
    }

    override fun createBip39Wallet(): Bip39Wallet {
        val entropy = Mnemonics.MnemonicCode(Mnemonics.WordCount.COUNT_24).toEntropy()
        return AlgorandBip39Wallet(Bip39Entropy(entropy))
    }
}
