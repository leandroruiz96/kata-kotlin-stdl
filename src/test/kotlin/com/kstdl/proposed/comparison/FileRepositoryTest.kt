package com.kstdl.proposed.comparison

import com.kstdl.comparison.File
import com.kstdl.comparison.FileRepository
import com.kstdl.comparison.Worker
import org.junit.Assert.*
import org.junit.Test

class FileRepositoryTest {

    @Test
    fun `sort descending by id`() {
        val fileRepository = FileRepository(files)

        val result = fileRepository.sortById()

        assertEquals(listOf(file1,file2,file3,file4,file5,file6),result)
    }

    @Test
    fun `file between files range`() {
        val fileRepository = FileRepository(listOf(file1,file6))

        assertTrue(fileRepository.shouldTakeFile(file3))
        assertTrue(fileRepository.shouldTakeFile(file4))
        assertTrue(fileRepository.shouldTakeFile(file2))
        assertTrue(fileRepository.shouldTakeFile(file5))
    }

    @Test
    fun `file outside files range`() {
        val fileRepository = FileRepository(listOf(file2,file4))

        assertFalse(fileRepository.shouldTakeFile(file1))
        assertFalse(fileRepository.shouldTakeFile(file5))
        assertFalse(fileRepository.shouldTakeFile(file6))
    }

    @Test
    fun `sort by name and last name`() {
        val fileRepository = FileRepository(files)

        val result = fileRepository.sortByWorkerName()

        assertEquals(listOf(file3,file6,file1,file5,file2,file4), result)
    }

    @Test
    fun `file for best paid worker`() {
        val fileRepository = FileRepository(files)

        val result = fileRepository.bestPaidWorkerFile()

        assertEquals(file4, result)
    }

    @Test
    fun `file for the youngest`() {
        val fileRepository = FileRepository(files)

        assertEquals(file2,fileRepository.youngestWorkerFile())
    }

    val worker1 get() = Worker("Ale", "Garin", 41, 4)
    val worker2 get() = Worker("JoJo", "Duran", 22, 1)
    val worker3 get() = Worker("Agus", "Rodriguez", 30, 6)
    val worker4 get() = Worker("Leu", "Ruiz", 24, 1)
    val worker5 get() = Worker("Diega", "Perez", 41, 1)
    val worker6 get() = Worker("Ale", "D'Aquino", 31, 1)

    val file1 get() = File("1",worker1,8, 10f)
    val file2 get() = File("2",worker2,10, null)
    val file3 get() = File("3",worker3,4, 11f)
    val file4 get() = File("4",worker4,9, 15f)
    val file5 get() = File("5",worker5,6, null)
    val file6 get() = File("6",worker6,6, null)

    val files get() = listOf(file1, file5, file3, file6, file2, file4)
}