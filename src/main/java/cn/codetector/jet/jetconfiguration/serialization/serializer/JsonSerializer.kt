package cn.codetector.jet.jetconfiguration.serialization.serializer

import cn.codetector.jet.jetconfiguration.JetConfiguration
import cn.codetector.jet.jetconfiguration.JetConfigurationImpl
import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializer
import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializerOption
import cn.codetector.jet.jetconfiguration.util.asString
import cn.codetector.jet.jetconfiguration.util.writeString
import com.google.common.base.Strings
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

/**
 * Created by Codetector on 2017/3/8.
 * Project Jet
 */
class JsonSerializer : JetConfigurationSerializer {
    override fun deserializeConfiguration(option: JetConfigurationSerializerOption): JetConfiguration {
        if (!option.location.exists()) {
            option.location.createNewFile()
        }
        val fileResult = option.location.asString()
        val gsonBuilder = GsonBuilder().serializeNulls()
        if (option.beautify) {
            gsonBuilder.setPrettyPrinting()
        }
        val stringStringMap = object : TypeToken<Map<String, Any>>() {}.type
        val map: Map<String, Any>
        if (fileResult.isNullOrEmpty()) {
            map = HashMap()
        } else {
            map = gsonBuilder.create().fromJson(fileResult, stringStringMap)
        }
        return JetConfigurationImpl(map, this, option)
    }

    override fun serializeConfiguration(configuration: JetConfiguration, option: JetConfigurationSerializerOption): String {
        val gsonBuilder = GsonBuilder().serializeNulls()
        if (option.beautify) {
            gsonBuilder.setPrettyPrinting()
        }
        return gsonBuilder.create().toJson(configuration.getValueStore())
    }

    override fun save(configuration: JetConfiguration, option: JetConfigurationSerializerOption) {
        option.location.writeString(serializeConfiguration(configuration, option))
    }
}