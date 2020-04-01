package com.kstdl.proposed.collections

import kotlin.math.roundToInt

class Subject(val name: String) {

    private val grades: MutableMap<Student,MutableCollection<Grade>> = hashMapOf()

    fun add(student: Student) {
        grades.putIfAbsent(student, mutableListOf())
    }

    fun addGrade(student: Student, grade: Grade) {
        grades.getOrPut(student,::mutableListOf).add(grade)
    }

    fun buildReport() : Map<Student,Grade> =
        grades.mapValues {
            it.value.asSequence()
                .map(Grade::value)
                .average()
                .roundToInt()
                .let(::Grade)
        }

    fun findFailingStudents() : Collection<Student> =
        buildReport()
            .filter { it.value.status == Grade.Status.Fail }
            .keys

    fun findApprovedStudents() : Collection<Student> =
        buildReport()
            .filterNot { it.value.status == Grade.Status.Fail }
            .keys

    fun findPromotedStudents() : Collection<Student> =
        grades
            .filterValues { it.all { grade -> grade.status == Grade.Status.Pass } }
            .keys
}