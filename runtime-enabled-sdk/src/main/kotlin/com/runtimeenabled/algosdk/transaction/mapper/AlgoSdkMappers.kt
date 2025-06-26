package com.runtimeenabled.algosdk.transaction.mapper

import com.runtimeenabled.algosdk.transaction.model.ApplicationCallStateSchema
import com.runtimeenabled.algosdk.transaction.model.AssetConfigParameters
import com.runtimeenabled.algosdk.transaction.model.RawTransaction
import com.runtimeenabled.algosdk.transaction.model.RawTransactionType
import com.runtimeenabled.algosdk.transaction.model.payload.RawTransactionApplicationCallStateSchemaPayload
import com.runtimeenabled.algosdk.transaction.model.payload.RawTransactionAssetConfigParametersPayload
import com.runtimeenabled.algosdk.transaction.model.payload.RawTransactionPayload
import com.runtimeenabled.algosdk.transaction.model.payload.RawTransactionTypePayload

internal interface RawTransactionMapper {
    operator fun invoke(payload: RawTransactionPayload): RawTransaction
}

internal interface RawTransactionTypeMapper {
    operator fun invoke(payload: RawTransactionTypePayload): RawTransactionType
}

internal interface AssetConfigParametersMapper {
    operator fun invoke(payload: RawTransactionAssetConfigParametersPayload?): AssetConfigParameters
}

internal interface ApplicationCallStateSchemaMapper {
    operator fun invoke(payload: RawTransactionApplicationCallStateSchemaPayload?): ApplicationCallStateSchema
}
