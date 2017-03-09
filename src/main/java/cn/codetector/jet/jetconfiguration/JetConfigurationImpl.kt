package cn.codetector.jet.jetconfiguration

import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializer
import cn.codetector.jet.jetconfiguration.serialization.JetConfigurationSerializerOption

/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class JetConfigurationImpl(map: Map<String, Any> = HashMap(), override var configurationSerializer: JetConfigurationSerializer, val options: JetConfigurationSerializerOption) : JetConfiguration {
    private val store: MutableMap<String, Any> = HashMap(map)

    override fun getValueStore(): Map<String, Any> {
        return this.store
    }


    init {
        save()
    }
    override fun getString(key: String, defaultValue: String): String {
        if (store.containsKey(key)) {
            return store[key].toString()
        } else {
            set(key, defaultValue)
            return getString(key, defaultValue)
        }
    }

    override fun set(key: String, value: String) {
        store.put(key, value)
        this.save()
    }

    override fun getInteger(key: String, defaultValue: Int): Int {
        if (store.containsKey(key) && store[key] is Int || store[key] is Double) {
            return (store[key] as Double).toInt()
        } else {
            set(key, defaultValue)
            return getInteger(key, defaultValue)
        }
    }

    override fun set(key: String, value: Int) {
        store.put(key, value.toDouble())
        this.save()
    }

    override fun getDouble(key: String, defaultValue: Double): Double {
        if (store.containsKey(key) && store[key] is Double) {
            return store[key] as Double
        } else {
            set(key, defaultValue)
            return getDouble(key, defaultValue)
        }
    }

    override fun set(key: String, value: Double) {
        store.put(key, value)
        this.save()
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        if (store.containsKey(key) && store[key] is Boolean) {
            return store[key] as Boolean
        } else {
            set(key, defaultValue)
            return getBoolean(key, defaultValue)
        }
    }

    override fun set(key: String, value: Boolean) {
        store.put(key, value)
        this.save()
    }

    override fun getCollection(key: String): Collection<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(key: String, value: Collection<String>) {
        store.put(key, value)
        this.save()
    }

    override fun toString(): String {
        return store.toString()
    }

    override fun save() {
        this.configurationSerializer.save(this, options)
    }
}