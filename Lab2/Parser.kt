package iniParser

interface Parser {
    fun parse(lines: List<String>): ConfigurationData
}
