package com.michaeltchuang.walletsdk.runtimeaware.account.data.repository

import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.HdSeedDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.mapper.entity.HdSeedEntityMapper
import com.michaeltchuang.walletsdk.runtimeaware.account.data.mapper.model.HdSeedMapper
import com.michaeltchuang.walletsdk.runtimeaware.account.domain.model.local.HdSeed
import com.michaeltchuang.walletsdk.runtimeaware.account.domain.repository.local.HdSeedRepository
import com.michaeltchuang.walletsdk.runtimeaware.encryption.domain.manager.AESPlatformManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


internal class HdSeedRepositoryImpl(
    private val hdSeedDao: HdSeedDao,
    private val hdSeedEntityMapper: HdSeedEntityMapper,
    private val hdSeedMapper: HdSeedMapper,
    private val aesPlatformManager: AESPlatformManager,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HdSeedRepository {

    override fun getAllAsFlow(): Flow<List<HdSeed>> {
        return hdSeedDao.getAllAsFlow().map { entityList ->
            entityList.map { entity -> hdSeedMapper(entity) }
        }
    }

    override fun getSeedCountAsFlow(): Flow<Int> {
        return hdSeedDao.getTableSizeAsFlow()
    }

    override suspend fun getHdSeedCount(): Int {
        return hdSeedDao.getTableSize()
    }

    override suspend fun getMaxSeedId(): Int? {
        return hdSeedDao.getMaxSeedId()
    }

    override suspend fun hasAnySeed(): Boolean {
        return hdSeedDao.hasAnySeed()
    }

    override suspend fun getSeedIdIfExistingEntropy(entropy: ByteArray): Int? {
        val entities = hdSeedDao.getAll()

        for (entity in entities) {
            val decryptedEntropy = aesPlatformManager.decryptByteArray(entity.encryptedEntropy)
            if (entropy.contentEquals(decryptedEntropy)) {
                return entity.seedId
            }
        }

        return null
    }

    override suspend fun getAllHdSeeds(): List<HdSeed> {
        return withContext(coroutineDispatcher) {
            val entities = hdSeedDao.getAll()
            entities.map { hdSeedMapper(it) }
        }
    }

    override suspend fun getHdSeed(seedId: Int): HdSeed? {
        return withContext(coroutineDispatcher) {
            hdSeedDao.get(seedId)?.let { hdSeedMapper(it) }
        }
    }

    override suspend fun addHdSeed(seedId: Int, entropy: ByteArray, seed: ByteArray): Long {
        return withContext(coroutineDispatcher) {
            val hdKeyEntity = hdSeedEntityMapper(seedId, entropy, seed)
            val seedId = hdSeedDao.insert(hdKeyEntity)
            seedId
        }
    }

    override suspend fun deleteHdSeed(seedId: Int) {
        withContext(coroutineDispatcher) {
            hdSeedDao.delete(seedId)
            if (hdSeedDao.getTableSize() < 1) {
                hdSeedDao.clearPrimaryKeyIndex()
            }
        }
    }

    override suspend fun deleteAllHdSeeds() {
        withContext(coroutineDispatcher) {
            hdSeedDao.clearAll()
            hdSeedDao.clearPrimaryKeyIndex()
        }
    }

    override suspend fun getEntropy(seedId: Int): ByteArray? {
        return withContext(coroutineDispatcher) {
            val encryptedSK = hdSeedDao.get(seedId)?.encryptedEntropy
            encryptedSK?.let { aesPlatformManager.decryptByteArray(it) }
        }
    }

    override suspend fun getSeed(seedId: Int): ByteArray? {
        return withContext(coroutineDispatcher) {
            val encryptedSK = hdSeedDao.get(seedId)?.encryptedSeed
            encryptedSK?.let { aesPlatformManager.decryptByteArray(it) }
        }
    }
}
