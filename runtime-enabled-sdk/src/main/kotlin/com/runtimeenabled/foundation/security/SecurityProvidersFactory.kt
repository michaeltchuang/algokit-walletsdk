package com.runtimeenabled.foundation.security

internal interface SecurityProvidersFactory {
    fun getProviders(): List<SecurityProvider>
}
