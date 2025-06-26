package com.runtimeenabled.algosdk.transaction.sdk.mapper

import com.algorand.algosdk.sdk.SuggestedParams
import com.runtimeenabled.algosdk.transaction.sdk.model.SuggestedTransactionParams

internal interface SuggestedParamsMapper {
    operator fun invoke(params: SuggestedTransactionParams, addGenesis: Boolean): SuggestedParams
}
