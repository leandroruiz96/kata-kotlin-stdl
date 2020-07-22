package com.kstdl.proposed.collections

import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class SubjectTest {

    @Test
    fun `empty classroom`() {
        val subject = Subject("math")

        assertEquals(subject.findApprovedStudents(), emptySet<Student>())
        assertEquals(subject.findFailingStudents(), emptySet<Student>())
        assertEquals(subject.findPromotedStudents(), emptySet<Student>())
        assertEquals(subject.buildReport(), emptyMap<Student,Grade>())
    }

    @Test
    fun `pass student classroom`() {
        val subject = Subject("math")
        val student = Student(100,"Edna", "Moda")

        subject.addGrade(student, Grade(90))
        subject.addGrade(student, Grade(98))
        subject.addGrade(student, Grade(100))

        assertEquals(subject.findApprovedStudents(), setOf(student))
        assertEquals(subject.findFailingStudents(), emptySet<Student>())
        assertEquals(subject.findPromotedStudents(), setOf(student))
        assertEquals(subject.buildReport(), mapOf(student to Grade(96)))
    }

    @Test(expected = Exception::class)
    fun `student without grades classroom`() {
        val subject = Subject("math")
        val student1 = Student(100,"Edna", "Moda")
        val student2 = Student(100,"Lola", "Palloza")

        subject.add(student1)
        subject.add(student2)

        subject.findApprovedStudents()
    }

    @Test
    fun `fail student classroom`() {
        val subject = Subject("math")
        val student = Student(100,"Edna", "Moda")

        subject.addGrade(student, Grade(9))
        subject.addGrade(student, Grade(8))
        subject.addGrade(student, Grade(10))

        assertEquals(subject.findApprovedStudents(),emptySet<Student>())
        assertEquals(subject.findFailingStudents(), setOf(student))
        assertEquals(subject.findPromotedStudents(), emptySet<Student>())
        assertEquals(subject.buildReport(), mapOf(student to Grade(9)))
    }
}