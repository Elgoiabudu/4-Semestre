package arp.santos.testelistview.dao

import arp.santos.testelistview.models.Contato
import java.util.ArrayList

class DaoContato {
    fun listaContatos(): ArrayList<Contato> {
        val list: ArrayList<Contato> = ArrayList()
        list.add(
            Contato(
                "1",
                "Fulano",
                "fulano@beltrano.com.br",
                "12345",
                "Avenida Barao de Mauá, 1000, Maua-SP",
                "#"
            )
        )
        return list
    }
}