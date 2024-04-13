package arp.santos.testelistview.dao

import arp.santos.testelistview.models.Contato
import java.util.ArrayList

class DaoContato {
    fun listaContatos(): ArrayList<Contato> {
        val list:ArrayList<Contato> = ArrayList()
        list.add(Contato("Fulano", "fulano@beltrano.com.br", "12345", "Avenida Barao de Mauá, 1000, Maua-SP", "#"))
        list.add(Contato("Beltrano", "beltrano@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Ciclano", "ciclano@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Zé", "ze@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Jão", "jao@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Manoel", "manoel@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Fulano", "fulano@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Beltrano", "beltrano@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Ciclano", "ciclano@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Zé", "ze@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Jão", "jao@beltrano.com.br", "12345", "Rua tal, 12", "#"))
        list.add(Contato("Manoel", "manoel@beltrano.com.br", "12345", "Rua tal, 12", "#"))

        return list
    }
}