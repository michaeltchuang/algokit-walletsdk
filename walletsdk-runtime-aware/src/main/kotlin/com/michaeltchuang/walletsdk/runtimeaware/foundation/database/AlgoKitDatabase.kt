package com.michaeltchuang.walletsdk.runtimeaware.foundation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.Algo25Dao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.Algo25NoAuthDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.CustomAccountInfoDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.CustomHdSeedInfoDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.HdKeyDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.HdSeedDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.LedgerBleDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.NoAuthDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.Algo25Entity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.CustomAccountInfoEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.CustomHdSeedInfoEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.HdKeyEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.HdSeedEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.LedgerBleEntity
import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.model.NoAuthEntity
import com.michaeltchuang.walletsdk.runtimeaware.foundation.database.converters.BigDecimalTypeConverter
import com.michaeltchuang.walletsdk.runtimeaware.foundation.database.converters.BigIntegerTypeConverter

@TypeConverters(
    BigIntegerTypeConverter::class,
    BigDecimalTypeConverter::class,
)
@Database(
    entities = [
        LedgerBleEntity::class,
        NoAuthEntity::class,
        HdKeyEntity::class,
        HdSeedEntity::class,
        Algo25Entity::class,
        CustomAccountInfoEntity::class,
        CustomHdSeedInfoEntity::class,

    ],
    version = AlgoKitDatabase.DATABASE_VERSION
)
internal abstract class AlgoKitDatabase : RoomDatabase() {
    abstract fun ledgerBleDao(): LedgerBleDao
    abstract fun noAuthDao(): NoAuthDao
    abstract fun hdKeyDao(): HdKeyDao
    abstract fun hdSeedDao(): HdSeedDao
    abstract fun algo25Dao(): Algo25Dao
    abstract fun algo25NoAuthDao(): Algo25NoAuthDao
    abstract fun customAccountInfoDao(): CustomAccountInfoDao
    abstract fun customHdSeedInfoDao(): CustomHdSeedInfoDao

    companion object Companion {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "algokit_database"
    }
}
