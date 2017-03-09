package cn.codetector.jet.jetconfiguration

import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializerOption
import cn.codetector.jet.jetconfiguration.serialization.serializer.JsonSerializer
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import java.nio.file.NotDirectoryException


/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class ConfigurationManager {
    private var baseLocation = File("./")

    companion object {
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
                throw NotDirectoryException("${baseDirectory.absolutePath} is not a valid directory")
            }
        } else {
            baseDirectory.mkdirs()
        }
        this.baseLocation = baseDirectory
        return this
    }
    //Gerneatro Functions

    fun getJsonConfiguration(fileName: String) : JetConfiguration{
        var actualFileName: String = fileName
        if (!actualFileName.toLowerCase().endsWith(".json")) {
            actualFileName += ".json"
        }
        return jsonSerializer.deserializeConfiguration(JetConfigurationSerializerOption(baseLocation.resolve(actualFileName)))
    }
}