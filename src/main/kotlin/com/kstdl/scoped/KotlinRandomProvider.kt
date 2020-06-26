package com.kstdl.scoped

import kotlin.random.Random

class KotlinRandomProvider(seed: Int) : RandomProvider {

    private val rng = Random(seed)

    override fun randomInt(): Int = rng.nextInt()

    override fun randomBytes(): ByteArray = rng.nextBytes(8)

    override fun randomBool(): Boolean = rng.nextBoolean()

    override fun randomFloat(): Float = rng.nextFloat()
}