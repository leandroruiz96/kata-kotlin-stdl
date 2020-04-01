package com.kstdl.collections

import kotlin.math.roundToInt

class Subject(val name: String) {

    private val grades: MutableMap<Student,MutableCollection<Grade>> = hashMapOf()

    fun add(student: Student) {
        if (grades[student] == null) {
            grades[student] = mutableListOf()
        }
    }

    fun addGrade(student: Student, grade: Grade) {
        val listOfGrades = grades[student]
        if (listOfGrades == null) {
            grades[student] = mutableListOf(grade)
        } else {
            listOfGrades.add(grade)
        }
    }

    fun buildReport() : Map<Student,Grade> {
        val res = mutableMapOf<Student,Grade>()

        for ((student,grades) in grades) {
            var avgGrade = 0f
            for (grade in grades) avgGrade += grade.value
            avgGrade /= grades.size.toFloat()

            res[student] = Grade(avgGrade.roundToInt())
        }

        return res
    }


    fun findFailingStudents() : Collection<Student> {
        val students = mutableSetOf<Student>()
        val report = buildReport()
        for ((student,grade) in report) {
            if (grade.status == Grade.Status.Fail) students.add(student)
        }
        return students
    }


    fun findApprovedStudents() : Collection<Student> {
        val students = mutableSetOf<Student>()
        val report = buildReport()
        for ((student,grade) in report) {
            if (grade.status != Grade.Status.Fail) students.add(student)
        }
        return students
    }

    fun findPromotedStudents() : Collection<Student> {
        val res = mutableSetOf<Student>()
        for ((student,grades) in grades) {
            var hasOnlyPass = true
            for (grade in grades) hasOnlyPass = hasOnlyPass && grade.status == Grade.Status.Pass

            if (hasOnlyPass) res.add(student)
        }
        return res
    }

}