package customBank

class ClientBuilder {
    private val client: Client = Client()

    fun withFirstName(firstName: String): ClientBuilder {
        client.firstName = firstName
        return this
    }

    fun withSecondName(secondName: String): ClientBuilder {
        client.secondName = secondName
        return this
    }

    fun withAddress(address: String): ClientBuilder {
        client.address = address
        return this
    }

    fun withPassportNumber(passportNumber: String): ClientBuilder {
        client.passportId = passportNumber
        return this
    }

    fun build(): Client {
        return client
    }
}
