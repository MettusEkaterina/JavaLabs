package iniParser

import java.util.HashMap

class LineParser : Parser {
    private var currentSection: String? = null
    private val data = HashMap<String, Map<String, String>>()

    override fun parse(lines: List<String>): ConfigurationData {
        for (line in lines) {
            val trimmedLine = cutComment(line).trim { it == ' ' }
            if (trimmedLine.isEmpty()) {
                continue
            }

            val isCategoryGet = tryGetCategory(trimmedLine)
            if (!isCategoryGet) {
                if (currentSection == null) {
                    throw IniParseException("Category wasn't set before key-value line")
                }

                if (!TryGetValue(trimmedLine)) {
                    throw IniParseException("Can't parse row:\n$trimmedLine")
                }
            }
        }
        return ConfigurationData(data)
    }

    private fun tryGetCategory(pLine: String): Boolean {
        var line = pLine
        if (line[0] == '[' && line[line.length - 1] == ']') {
            line = line
                    .replace("[", "")
                    .replace("]", "")

            if (line.matches("[a-zA-Z_]*".toRegex())) {
                currentSection = line
                return true
            }
        }

        return false
    }

    private fun TryGetValue(line: String): Boolean {
        val parts = line.split("=".toRegex(), 2).toTypedArray()

        if (parts.size != 2) {
            return false
        }

        val key = parts[0].trim { it == ' ' }
        val value = parts[1].trim { it == ' ' }
        if (!key.matches("[a-zA-Z_]*".toRegex())) {
            return false
        }

        if (!value.matches("[a-zA-Z_./0-9]*".toRegex())) {
            return false
        }

        addValues(currentSection, key, value)
        return true
    }

    private fun cutComment(line: String): String {
        if (line.contains(";")) {
            val parts = line.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return parts[0]
        }
        return line
    }

    private fun addValues(section: String?, key: String, value: String) {
        if (!data.containsKey(section)) {
            data[section!!] = HashMap()
        }
        val currentDictionary = data[section] as MutableMap
        currentDictionary[key] = value
    }
}
