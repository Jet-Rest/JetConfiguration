package cn.codetector.jet.jetconfiguration

import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializerOption
import cn.codetector.jet.jetconfiguration.serialization.serializer.JsonSerializer
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.file.NotDirectoryException


/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class ConfigurationManager {
    private var baseLocation = File("./")

    companion object {
        private val logger = LoggerFactory.getLogger(ConfigurationManager::class.java)
        val jsonSerializer = JsonSerializer()

        val defaultManager: ConfigurationManager
            get() {
                return ConfigurationManager()
            }
    }

    //Settings functions
    fun setBaseDirectory(baseDirectory: File) : ConfigurationManager{
        if (baseDirectory.exists()) {
            if (!baseDirectory.isDirectory) {
                val e = NotDirectoryException("${baseDirectory.absolutePath} is not a valid directory")
                logger.error("Failed to set configuration base directory", e)
                throw e
            }
        } else {
            logger.debug("Making directories for configuration file")
            baseDirectory.mkdirs()
        }
        this.baseLocation = baseDirectory
        return this
    }
    //Generators Functions

    fun getJsonConfiguration(fileName: String) : JetConfiguration{
        var actualFileName: String = fileName
        if (!actualFileName.toLowerCase().endsWith(".json")) {
            actualFileName += ".json"
        }
        return jsonSerializer.deserializeConfiguration(JetConfigurationSerializerOption(baseLocation.resolve(actualFileName)))
    }
}