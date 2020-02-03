package com.kstdl.scoped

data class Destination(
    val address: String,
    val buffer: Long,
    val verificationHash: String
) {
    override fun toString(): String {
        return "{ a -> $address <> vh -> $verificationHash }"
    }
}