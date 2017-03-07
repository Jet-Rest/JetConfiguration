package cn.codetector.jet.jetconfiguration

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by codetector on 07/03/2017.
 */
internal class ConfigurationManagerTest {
    @Test
    fun deserializeJson() {
        val config = ConfigurationManager().deserializeJson("{\"test\":\"magic\"}")
        println(config)
    }

    @Test
    fun serializeJson() {
        val config = JetConfigurationImpl()
        config.set("test", 1)
        config.set("testDouble", 1.2)
        val ser = (ConfigurationManager().serializeJson(config))
        val config2 = ConfigurationManager().deserializeJson(ser)
        println(config2)
    }

}