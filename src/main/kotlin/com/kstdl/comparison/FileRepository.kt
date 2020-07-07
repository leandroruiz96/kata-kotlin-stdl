package com.kstdl.comparison

import java.util.*

class FileRepository(private val files: Collection<File>) {

    fun sortById(): List<File> {
        val sorted = files.toMutableList()
        Collections.sort(sorted)
        return sorted
    }

    fun shouldTakeFile(file: File): Boolean {
        val min = Collections.min(files)
        val max = Collections.max(files)
        return min <= file && file <= max
    }

    fun sortByWorkerName(): List<File> {
        val sorted = files.toMutableList()
        Collections.sort(sorted) { current: File, next: File ->
            val comparison = current.worker.name.compareTo(next.worker.name)
            return@sort if (comparison == 0) {
                current.worker.lastName.compareTo(next.worker.lastName)
            }  else comparison
        }
        return sorted
    }

    fun bestPaidWorkerFile(): File? {
        var max: File? = null
        for (file in files) {
            val salary = file.salary
            val maxSalary = max?.salary
            if (max == null || maxSalary == null || salary != null && salary > maxSalary) {
                max = file
            }
        }
        return max
    }

    fun youngestWorkerFile(): File? {
        var max: File? = null
        for (file in files) {
            val maxAge = max?.worker?.age
            if (maxAge == null || file.worker.age < maxAge) {
                max = file
            }
        }
        return max
    }

}