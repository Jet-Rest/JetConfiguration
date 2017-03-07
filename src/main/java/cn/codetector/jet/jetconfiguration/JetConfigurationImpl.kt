package cn.codetector.jet.jetconfiguration

/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class JetConfigurationImpl(map: Map<String, Any> = HashMap()) : JetConfiguration {

    private val store: MutableMap<String, Any> = HashMap(map)

    override fun getValueStore(): Map<String, Any> {
        return this.store
    }

    override fun getString(key: String, defaultValue: String): String {
        if (store.containsKey(key) && store[key] is String) {
            return store[key] as String
        } else {
            set(key, defaultValue)
            return getString(key, defaultValue)
        }
    }

    override fun set(key: String, value: String) {
        store.put(key, value)
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
    }

    override fun getCollection(key: String): Collection<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(key: String, value: Collection<String>) {
        store.put(key, value)
    }

    override fun toString(): String {
        return store.toString()
    }
}