package com.michaeltchuang.walletsdk.runtimeaware.account.data.mapper.entity

import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.CustomAccountInfoEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.domain.model.custom.CustomAccountInfo

internal class CustomAccountInfoEntityMapperImpl : CustomAccountInfoEntityMapper {

    override fun invoke(customAccountInfo: CustomAccountInfo): CustomAccountInfoEntity {
        return CustomAccountInfoEntity(
            algoAddress = customAccountInfo.address,
            customName = customAccountInfo.customName,
            orderIndex = customAccountInfo.orderIndex,
            isBackedUp = customAccountInfo.isBackedUp
        )
    }
}
