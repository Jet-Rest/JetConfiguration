package cn.codetector.jet.jetconfiguration

import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializer

/**
 * Created by Codetector on 2017/3/6.
 * Project Classroom
 */
interface JetConfiguration {
    var configurationSerializer: JetConfigurationSerializer

    fun save()

    fun getValueStore():Map<String, Any>

    fun getString(key: String, defaultValue: String = String()):String
    fun set(key:String, value: String)

    fun getInteger(key: String, defaultValue: Int): Int
    fun set(key: String, value: Int)

    fun getDouble(key: String, defaultValue: Double): Double
    fun set(key: String, value: Double)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun set(key: String, value: Boolean)

    fun getCollection(key: String): Collection<String>
    fun set(key: String, value: Collection<String>)
}