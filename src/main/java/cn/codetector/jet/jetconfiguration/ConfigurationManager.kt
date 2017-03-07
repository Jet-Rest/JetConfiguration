package cn.codetector.jet.jetconfiguration

import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.GsonBuilder


/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class ConfigurationManager {
    fun deserializeJson(json: String): JetConfiguration {
        val gson: Gson = GsonBuilder().serializeNulls().create()!!
        val stringStringMap = object : TypeToken<Map<String, Any>>() {}.type
        val map: Map<String, Any> = gson.fromJson(json, stringStringMap)
        return JetConfigurationImpl(map)
    }

    fun serializeJson(config: JetConfiguration): String {
        val gson: Gson = GsonBuilder().serializeNulls().create()
        return gson.toJson(config.getValueStore())
    }
}