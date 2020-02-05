package com.kstdl.proposed.scoped

import java.nio.charset.Charset
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter
import javax.xml.crypto.Data

data class Message(
    val destination: Destination,
    val method: Method,
    val algorithm: MessageDigest
) {

    private var message: String? = null
    private var ssNumber: SSNumber? = null
    private var payload: Any? = null
    private var hash: String = buildHash()

    fun updatePayload(payload: Any) {
        this.payload = payload
        updateHash()
    }

    fun updateSSNumber(ssn: SSNumber) {
        this.ssNumber = ssn
        updateHash()
    }

    fun buildMessage(): String =
        StringBuilder().apply {

            append("d -> $destination")

            message?.let { append("\nm -> $it") }
            ssNumber?.let { append("\nssn -> $it") }
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