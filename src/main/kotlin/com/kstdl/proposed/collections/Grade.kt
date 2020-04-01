package com.kstdl.proposed.collections

data class Grade(val value: Int) {
    init {
        require(value in 0..100) { "Invalid grade of $value. Must be in [0,100]" }
    }

    val status: Status get() = when (value) {
        in 0 until 50 -> Status.Fail
        in 50 until 75 -> Status.Conditional
        else -> Status.Pass
    }


    enum class Status {
        Pass,
        Conditional,
        Fail,
    }
}