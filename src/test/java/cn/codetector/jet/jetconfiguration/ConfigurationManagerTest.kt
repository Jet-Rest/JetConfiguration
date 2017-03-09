package cn.codetector.jet.jetconfiguration

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.File

/**
 * Created by codetector on 07/03/2017.
 */
internal class ConfigurationManagerTest {
    val testDir = File("./testFolder")

    @BeforeEach
    fun createTestFolder () {
        removeTestFolder()
        testDir.mkdirs()
        assertTrue(testDir.exists()) // Guarantee the directory is made
    }

    @Test
    fun testJsonConfigurationFileGeneration() {
        val config = ConfigurationManager.defaultManager.setBaseDirectory(testDir).getJsonConfiguration("test")
        assertTrue(testDir.resolve("test.json").exists())
    }

    @AfterEach
    fun removeTestFolder () {
        if (testDir.exists()) {
            testDir.deleteRecursively()
        }
        assertFalse(testDir.exists()) // Guarantee the directory is removed
    }
}