package com.kstdl.scoped

import java.nio.charset.Charset
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

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

    fun buildMessage() : String {
        val builder = StringBuilder()
            .append("d -> ")
            .append(destination.toString())

        if (message != null) {
            builder.append('\n')
                .append("m -> ")
                .append(message)
        }

        if (ssNumber!=null) {
            builder.append('\n')
                .append("ssn -> ")
                .append(ssNumber.toString())
        }

        if (payload!=null) {
            builder.append('\n')
                .append("payload -> \"")
                .append(payload.toString())
                .append('\"')
        }

        builder
            .append('\n')
            .append("hash -> ")
            .append(hash)

        return builder.toString()
    }

    private fun updateHash() {
        this.hash = buildHash()
    }

    private fun buildHash() : String {
        var toHash = ""
        if (message!=null) {
            toHash += message
        }
        if (payload!=null) {
            toHash += payload
        }
        val bytes = toHash.toByteArray()
        val hash = algorithm.digest(bytes)
        return DatatypeConverter.printHexBinary(hash)
    }

}