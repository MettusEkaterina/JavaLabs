package iniParser

object IniParser {
    @JvmStatic
    fun parseFile(fileName: String): ConfigurationData {
        val reader: DataReader = FileDataReader(fileName)
        val parser: Parser = LineParser()
        val lines = reader.read()
        return parser.parse(lines)
    }
}
