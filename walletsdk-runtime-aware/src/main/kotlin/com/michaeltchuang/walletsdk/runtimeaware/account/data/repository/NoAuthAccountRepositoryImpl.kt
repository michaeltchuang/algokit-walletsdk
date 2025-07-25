package com.michaeltchuang.walletsdk.runtimeaware.account.data.repository

import com.michaeltchuang.walletsdk.runtimeaware.account.data.database.dao.NoAuthDao
import com.michaeltchuang.walletsdk.runtimeaware.account.data.mapper.entity.NoAuthEntityMapper
import com.michaeltchuang.walletsdk.runtimeaware.account.data.mapper.model.NoAuthMapper
import com.michaeltchuang.walletsdk.runtimeaware.account.domain.model.local.LocalAccount.NoAuth
import com.michaeltchuang.walletsdk.runtimeaware.account.domain.repository.local.NoAuthAccountRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class NoAuthAccountRepositoryImpl(
    private val noAuthDao: NoAuthDao,
    private val noAuthEntityMapper: NoAuthEntityMapper,
    private val noAuthMapper: NoAuthMapper,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : NoAuthAccountRepository {

    override fun getAllAsFlow(): Flow<List<NoAuth>> {
        return noAuthDao.getAllAsFlow().map { entityList ->
            entityList.map { entity -> noAuthMapper(entity) }
        }
    }

    override fun getAccountCountAsFlow(): Flow<Int> {
        return noAuthDao.getTableSizeAsFlow()
    }

    override suspend fun getAccountCount(): Int {
        return noAuthDao.getTableSize()
    }

    override suspend fun getAll(): List<NoAuth> {
        return withContext(coroutineDispatcher) {
            val noAuthEntities = noAuthDao.getAll()
            noAuthEntities.map { noAuthMapper(it) }
        }
    }

    override suspend fun getAllAddresses(): List<String> {
        return withContext(coroutineDispatcher) {
            noAuthDao.getAllAddresses()
        }
    }

    override suspend fun getAccount(address: String): NoAuth? {
        return withContext(coroutineDispatcher) {
            val noAuthEntity = noAuthDao.get(address)
            noAuthEntity?.let { noAuthMapper(it) }
        }
    }

    override suspend fun addAccount(account: NoAuth) {
        withContext(coroutineDispatcher) {
            val noAuthEntity = noAuthEntityMapper(account)
            noAuthDao.insert(noAuthEntity)
        }
    }

    override suspend fun deleteAccount(address: String) {
        withContext(coroutineDispatcher) {
            noAuthDao.delete(address)
        }
    }

    override suspend fun deleteAllAccounts() {
        withContext(coroutineDispatcher) {
            noAuthDao.clearAll()
        }
    }

    override suspend fun isAddressExists(address: String): Boolean {
        return withContext(coroutineDispatcher) {
            noAuthDao.isAddressExists(address)
        }
    }
}
