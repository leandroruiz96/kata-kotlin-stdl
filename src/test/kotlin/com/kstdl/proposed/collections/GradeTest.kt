package com.kstdl.proposed.collections

import org.junit.Assert.*
import org.junit.Test
import org.junit.matchers.JUnitMatchers
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class GradeTest(private val grade: Int, private val status: Grade.Status) {

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf(5, Grade.Status.Fail),
                arrayOf(25, Grade.Status.Fail),
                arrayOf(40, Grade.Status.Fail),
                arrayOf(49, Grade.Status.Fail),
                arrayOf(50, Grade.Status.Conditional),
                arrayOf(55, Grade.Status.Conditional),
                arrayOf(66, Grade.Status.Conditional),
                arrayOf(74, Grade.Status.Conditional),
                arrayOf(75, Grade.Status.Pass),
                arrayOf(80, Grade.Status.Pass),
                arrayOf(99, Grade.Status.Pass),
                arrayOf(100, Grade.Status.Pass)
            )
        }
    }



    @Test
    fun testCases() {
        assert(Grade(grade).status == status)
    }
}