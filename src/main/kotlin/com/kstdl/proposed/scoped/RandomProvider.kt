package com.kstdl.proposed.scoped

interface RandomProvider {
    fun randomInt(): Int
    fun randomBytes(): ByteArray
    fun randomBool(): Boolean
    fun randomFloat(): Float
}