package com.michaeltchuang.walletsdk.runtimeaware.account.domain.model.core

import android.os.Parcelable
import com.michaeltchuang.walletsdk.runtimeaware.utils.CreationType
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountCreation(
    val address: String,
    var customName: String?,
    var orderIndex: Int = Int.MAX_VALUE,
    val isBackedUp: Boolean,
    val type: Type,
    val creationType: CreationType
) : Parcelable {

    sealed interface Type : Parcelable {
        @Parcelize
        data class HdKey(
            val publicKey: ByteArray,
            val encryptedPrivateKey: ByteArray,
            val encryptedEntropy: ByteArray,
            val account: Int,
            val change: Int,
            val keyIndex: Int,
            val derivationType: Int,
            val seedId: Int? = null
        ) : Type

        @Parcelize
        data class Algo25(
            val encryptedSecretKey: ByteArray
        ) : Type

        @Parcelize
        data class LedgerBle(
            val deviceMacAddress: String,
            val indexInLedger: Int,
            val bluetoothName: String?
        ) : Type

        @Parcelize
        data object NoAuth : Type
    }

    fun toCreateAccount(): CreateAccount {
        return CreateAccount(
            address = address,
            customName = customName,
            orderIndex = orderIndex,
            isBackedUp = isBackedUp,
            type = when (type) {
                is Type.HdKey -> CreateAccount.Type.HdKey(
                    type.publicKey,
                    type.encryptedPrivateKey,
                    type.encryptedEntropy,
                    type.account,
                    type.change,
                    type.keyIndex,
                    type.derivationType,
                )

                is Type.Algo25 -> CreateAccount.Type.Algo25(
                    type.encryptedSecretKey
                )

                is Type.LedgerBle -> CreateAccount.Type.LedgerBle(
                    type.deviceMacAddress,
                    type.indexInLedger,
                    type.bluetoothName
                )

                is Type.NoAuth -> CreateAccount.Type.NoAuth
            }
        )
    }
}
