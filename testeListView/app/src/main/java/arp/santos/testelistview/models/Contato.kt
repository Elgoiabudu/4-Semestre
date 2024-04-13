package arp.santos.testelistview.models

import java.io.Serializable
import java.io.StringBufferInputStream

class Contato (
    val nome: String,
    val email: String,
    val telefone: String,
    val endereco: String,
    val foto: String
    ): Serializable {


}