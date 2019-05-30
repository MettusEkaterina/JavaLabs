package customBank

class Client {
    var firstName: String? = null
    var secondName: String? = null
    var address: String? = null
    var passportId: String? = null

    companion object {

        fun newBuilder(): ClientBuilder {
            return ClientBuilder()
        }

        fun newDefault(): Client {
            return newBuilder()
                    .withFirstName("Vasya")
                    .withSecondName("Pupkin")
                    .withAddress("Lopuhovo")
                    .withPassportNumber("65465")
                    .build()
        }
    }
}
