package com.kstdl.scoped

interface RandomProvider {
    fun randomInt(): Int
    fun randomBytes(): ByteArray
    fun randomBool(): Boolean
    fun randomFloat(): Float
}