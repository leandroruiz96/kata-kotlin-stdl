package com.kstdl.proposed.scoped

import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor
import kotlin.math.absoluteValue

class OneTimePad(
    private val rngProvider: RandomProvider
) {
    override fun toString(): String {
        with(rngProvider) {
            val base = randomBytes()
            val top = randomBytes()
            val fuzziness = randomFloat()

            return base.mapIndexed { index, byte ->
                val index = if (randomFloat() < fuzziness) randomInt().absoluteValue.rem(8) else index

                return@mapIndexed if (randomBool()) {
                    byte.xor(top[index]).inv()
                } else {
                    byte.or(top[index].inv())
                }
            }.toString()
        }
    }
}