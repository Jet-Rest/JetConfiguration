package cn.codetector.jet.jetconfiguration.serialization

import cn.codetector.jet.jetconfiguration.JetConfiguration
import java.io.File

/**
 * Created by Codetector on 2017/3/8.
 * Project Jet
 */
interface JetConfigurationSerializer {
    fun deserializeConfiguration(option: JetConfigurationSerializerOption): JetConfiguration
    fun serializeConfiguration(configuration: JetConfiguration, option: JetConfigurationSerializerOption): String
    fun save(configuration: JetConfiguration, option: JetConfigurationSerializerOption)
}