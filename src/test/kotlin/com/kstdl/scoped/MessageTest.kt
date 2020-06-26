package com.kstdl.scoped

import org.junit.Assert.*
import org.junit.Test
import java.security.MessageDigest

class MessageTest {

    lateinit var message: Message

    @Test
    fun `empty message building`() {
        givenDefaultMessage()

        assertEquals(
            "d -> { a -> address <> vh -> sserdda }\nhash -> DA39A3EE5E6B4B0D3255BFEF95601890AFD80709",
            message.buildMessage()
        )
    }

    @Test
    fun `updating payload`() {
        givenDefaultMessage()

        message.updatePayload(5)

        assertEquals(
            "d -> { a -> address <> vh -> sserdda }\n" +
                    "payload -> \"5\"\n" +
                    "hash -> AC3478D69A3C81FA62E60F5C3696165A4E5E6AC4",
            message.buildMessage()
        )
    }

    @Test
    fun `updating ssn`() {
        givenDefaultMessage()
        val rngProvider = KotlinRandomProvider(1)
        val otp = OneTimePad(rngProvider)

        message.updateOTP(OneTimePad(KotlinRandomProvider(1)))

        assertEquals(
            "d -> { a -> address <> vh -> sserdda }\n" +
                    "otp -> $otp\n" +
                    "hash -> DA39A3EE5E6B4B0D3255BFEF95601890AFD80709",
            message.buildMessage()
        )
    }

    private fun givenDefaultMessage() {
        message = Message(defaultDestination,defaultMethod,defaultAlgorithm)
    }

    private val defaultAlgorithm = MessageDigest.getInstance("SHA-1")
    private val defaultDestination = Destination("address",1000, "sserdda")
    private val defaultMethod = Method.doves
}