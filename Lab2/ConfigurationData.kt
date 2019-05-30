package iniParser

import java.io.File

class ConfigurationData(private val data: Map<String, Map<String, String>>) {

    fun getValue(region: String, key: String): String? {
        return data[region]?.get(key)
    }

    fun getIntValue(region: String, key: String): Int? {
        return getValue(region, key)?.toInt()
    }

    fun getDoubleValue(region: String, key: String): Double? {
        return getValue(region, key)?.toDouble()
    }

    companion object {
        fun from(file: File) : ConfigurationData = TODO()
    }
}
