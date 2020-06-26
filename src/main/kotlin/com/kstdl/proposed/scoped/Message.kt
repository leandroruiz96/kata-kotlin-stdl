package com.kstdl.proposed.scoped

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

data class Message(
    val destination: Destination,
    val method: Method,
    val algorithm: MessageDigest
) {

    private var message: String? = null
    private var oneTimePad: OneTimePad? = null
    private var payload: Any? = null
    private var hash: String = buildHash()

    fun updatePayload(payload: Any) {
        this.payload = payload
        updateHash()
    }

    fun updateOTP(otp: OneTimePad) {
        this.oneTimePad = otp
        updateHash()
    }

    fun buildMessage(): String =
        StringBuilder().apply {

            append("d -> $destination")

            message?.let { append("\nm -> $it") }
            oneTimePad?.let { append("\notp -> $it") }
            payload?.let { append("\npayload -> \"$it\"") }

            append("\nhash -> $hash")

        }.toString()

    private fun updateHash() {
        this.hash = buildHash()
    }

    private fun buildHash(): String =
        StringBuilder()
            .apply {
                message?.let(::append)
                payload?.let(::append)
            }
            .toString()
            .run {
                val digested = algorithm.digest(toByteArray())
                return DatatypeConverter.printHexBinary(digested)
            }

}