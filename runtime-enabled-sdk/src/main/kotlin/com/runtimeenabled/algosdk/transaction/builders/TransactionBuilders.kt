package com.runtimeenabled.algosdk.transaction.builders

import com.runtimeenabled.algosdk.transaction.model.Transaction.AddAssetTransaction
import com.runtimeenabled.algosdk.transaction.model.Transaction.AlgoTransaction
import com.runtimeenabled.algosdk.transaction.model.Transaction.AssetTransaction
import com.runtimeenabled.algosdk.transaction.model.Transaction.RekeyTransaction
import com.runtimeenabled.algosdk.transaction.model.Transaction.RemoveAssetTransaction
import com.runtimeenabled.algosdk.transaction.model.Transaction.SendAndRemoveAssetTransaction
import com.runtimeenabled.algosdk.transaction.sdk.model.AddAssetTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.AlgoTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.AssetTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.RekeyTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.RemoveAssetTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.SendAndRemoveAssetTransactionPayload
import com.runtimeenabled.algosdk.transaction.sdk.model.SuggestedTransactionParams

internal interface AddAssetTransactionBuilder {
    operator fun invoke(
        payload: AddAssetTransactionPayload,
        params: SuggestedTransactionParams
    ): AddAssetTransaction
}

internal interface AssetTransactionBuilder {
    operator fun invoke(
        payload: AssetTransactionPayload,
        params: SuggestedTransactionParams
    ): AssetTransaction
}

internal interface AlgoTransactionBuilder {
    operator fun invoke(
        payload: AlgoTransactionPayload,
        params: SuggestedTransactionParams
    ): AlgoTransaction
}

internal interface RekeyTransactionBuilder {
    operator fun invoke(
        payload: RekeyTransactionPayload,
        params: SuggestedTransactionParams
    ): RekeyTransaction
}

internal interface RemoveAssetTransactionBuilder {
    operator fun invoke(
        payload: RemoveAssetTransactionPayload,
        params: SuggestedTransactionParams
    ): RemoveAssetTransaction
}

internal interface SendAndRemoveAssetTransactionBuilder {
    operator fun invoke(
        payload: SendAndRemoveAssetTransactionPayload,
        params: SuggestedTransactionParams
    ): SendAndRemoveAssetTransaction
}
