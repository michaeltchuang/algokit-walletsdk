package com.runtimeenabled.foundation.security

internal interface SecurityManager {
    fun registerProvider(securityProvider: SecurityProvider)
}
