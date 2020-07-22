package com.kstdl.proposed.comparison


class FileRepository(private val files: Collection<File>) {

    fun sortById(): List<File> {
        return files.sorted()
    }

    fun shouldTakeFile(file: File): Boolean {
        val files = files.sorted()
        return file in files.first()..files.last()
    }

    fun sortByWorkerName(): List<File> {
        return files.sortedWith(compareBy<File> { it.worker.name }.thenBy { it.worker.lastName })
    }

    fun bestPaidWorkerFile(): File? {
        val comparator = nullsFirst<File>(compareBy { it.salary })
        return files.sortedWith(comparator).lastOrNull()
    }

    fun youngestWorkerFile(): File? {
        return files.minBy { it.worker.age }
    }

}