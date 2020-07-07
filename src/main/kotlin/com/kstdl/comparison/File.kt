package com.kstdl.comparison

data class File(
    val id: String,
    val worker: Worker,
    val workingHours: Int,
    val salary: Float?
) : Comparable<File> {
    override fun compareTo(other: File): Int {
        return id.compareTo(other.id)
    }
}