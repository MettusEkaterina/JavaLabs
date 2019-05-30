package iniParser

import java.io.File
import java.io.FileNotFoundException
import java.util.ArrayList
import java.util.Scanner

class FileDataReader(private val fileName: String) : DataReader {

    override fun read(): List<String> {
        val lines = ArrayList<String>()

        try {
            Scanner(File(fileName)).use { scanner ->

                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine())
                }
            }
        } catch (e: FileNotFoundException) {
            throw IniParseException("File $fileName can't be opened", e)
        }

        return lines
    }
}
