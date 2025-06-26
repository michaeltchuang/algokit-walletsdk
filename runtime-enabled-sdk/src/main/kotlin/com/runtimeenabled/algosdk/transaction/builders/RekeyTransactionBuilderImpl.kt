package com.runtimeenabled.algosdk.transaction.builders

import com.runtimeenabled.algosdk.transaction.model.Transaction
import com.runtimeenabled.algosdk.transaction.sdk.AlgoSdk
import com.runtimeenabled.algosdk.transaction.sdk.model.RekeyTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.SuggestedTransactionParams

internal class RekeyTransactionBuilderImpl(
    private val algoSdk: AlgoSdk
) : RekeyTransactionBuilder {

    override fun invoke(
        payload: RekeyTransactionPayload,
        params: SuggestedTransactionParams
    ): Transaction.RekeyTransaction {
        val txnByteArray = createTxnByteArray(payload, params)
        return Transaction.RekeyTransaction(payload.address, txnByteArray)
    }

    private fun createTxnByteArray(
        payload: RekeyTransactionPayload,
        params: SuggestedTransactionParams
    ): ByteArray {
        return algoSdk.createRekeyTxn(
            rekeyAddress = payload.address,
            rekeyAdminAddress = payload.rekeyAdminAddress,
            suggestedTransactionParams = params
        )
    }
}
