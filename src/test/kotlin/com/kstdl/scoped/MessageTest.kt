package com.kstdl.scoped

import org.junit.Assert.*
import org.junit.Test
import java.security.MessageDigest

class MessageTest {

    lateinit var message: Message

    @Test
    fun `updating payload`() {
        val destination = Destination("address",1000, "sserdda")
        val method = Method.doves
        val algorithm = MessageDigest.getInstance("SHA-1")
        message = Message(destination,method,algorithm)

        val body = message.buildMessage()
        message.updatePayload(5)

        assertNotEquals(body,message.buildMessage())
    }
}