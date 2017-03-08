package cn.codetector.jet.jetconfiguration.util

import com.google.common.io.Files
import java.io.File
import java.io.FileWriter
import java.nio.charset.Charset

/**
 * Created by Codetector on 2017/3/8.
 * Project Jet
 */
fun File.asString(encoding: String = "UTF-8"): String {
    return Files.asCharSource(this, Charset.forName(encoding)).read()
}

fun File.writeString(string: String) {
    val fileWriter = FileWriter(this)
    fileWriter.write(string)
    fileWriter.flush()
    fileWriter.close()
}