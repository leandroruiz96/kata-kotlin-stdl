package com.kstdl.scoped

import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor
import kotlin.math.absoluteValue

class OneTimePad(
    private val rngProvider: RandomProvider
) {
    override fun toString(): String {
        val base = rngProvider.randomBytes()
        val top = rngProvider.randomBytes()
        val fuzziness = rngProvider.randomFloat()

        return base.mapIndexed { index, byte ->
            val index = if (rngProvider.randomFloat() < fuzziness) {
                rngProvider.randomInt().absoluteValue.rem(8)
            } else {
                index
            }

            return@mapIndexed if (rngProvider.randomBool()) {
                byte.xor(top[index]).inv()
            } else {
                byte.or(top[index].inv())
            }
        }.toString()
    }
}