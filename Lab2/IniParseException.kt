package iniParser

class IniParseException(message: String) : Exception(message) {
    var innerException: Exception? = null

    constructor(message: String, innerException: Exception) : this(message) {
        this.innerException = innerException
    }
}
