package cn.codetector.jet.jetconfiguration.serialization

import java.io.File

/**
 * Created by Codetector on 2017/3/8.
 * Project Jet
 */
class JetConfigurationSerializerOption(var location: File) {
    var beautify: Boolean = true

    fun setLocation(file: File) : JetConfigurationSerializerOption {
        this.location = file
        return this
    }

    fun setBeautify(boolean: Boolean): JetConfigurationSerializerOption {
        this.beautify = boolean
        return this
    }
}