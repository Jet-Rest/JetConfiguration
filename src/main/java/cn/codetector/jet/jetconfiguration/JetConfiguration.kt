package cn.codetector.jet.jetconfiguration

/**
 * Created by Codetector on 2017/3/6.
 * Project Classroom
 */
interface JetConfiguration {
    fun get(key: String, defaultValue: Any = Any()):Any

    fun getString(key: String, defaultValue: String = String()):String
    fun set(key:String, value: String)

    fun getShort(key: String, defaultValue: Short): Short
    fun set(key: String, value: Short)

    fun getInteger(key: String, defaultValue: Int): Int
    fun set(key: String, value: Int)

    fun getFloat(key: String, defaultValue: Float): Float
    fun set(key: String, value: Float)

    fun getDouble(key: String, defaultValue: Double): Double
    fun set(key: String, value: Double)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun set(key: String, value: Boolean)

    fun getCollection(key: String): Collection<String>
    fun set(key: String, value: Collection<String>)
}