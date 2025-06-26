package com.runtimeenabled.algosdk.domain.usecase

import com.runtimeenabled.algosdk.transaction.sdk.AlgoKitBip39Sdk

class RecoverWithPassphrasePreviewUseCase(
    private val algokitBip39Sdk: AlgoKitBip39Sdk,
) {
    fun getAccount(
        mnemonics: String,
    ): String {
        val entropy = algokitBip39Sdk.getEntropyFromMnemonic(mnemonics)
        return entropy.contentToString()
    }
}
