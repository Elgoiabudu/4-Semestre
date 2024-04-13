package arp.santos.testelistview.models

import java.io.Serializable

class Contato (
    val _id: String,
    val nome: String,
    val email: String,
    val telefone: String,
    val endereco: String,
    val foto: String
    ): Serializable {
}