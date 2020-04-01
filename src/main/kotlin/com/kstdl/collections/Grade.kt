package com.kstdl.collections

data class Grade(val value: Int) {
    init {
        require(value in 0..100) { "Invalid grade of $value. Must be in [0,100]" }
    }

    val status: Status get() {
        if (value in 0..49) {
            return Status.Fail
        } else if (value in 50..74) {
            return Status.Conditional
        } else {
            return Status.Pass
        }
    }

    enum class Status {
        Pass,
        Conditional,
        Fail,
    }
}