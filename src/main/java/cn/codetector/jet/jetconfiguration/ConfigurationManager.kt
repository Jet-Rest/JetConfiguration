package cn.codetector.jet.jetconfiguration

import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.GsonBuilder


/**
 * Created by Codetector on 2017/3/7.
 * Project Classroom
 */
class ConfigurationManager {
    companion object {
        val defaultManager: ConfigurationManager
            get() {
                return ConfigurationManager()
            }
    }
}