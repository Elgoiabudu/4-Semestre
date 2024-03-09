package com.william.applista.dao

import com.william.applista.models.Contato


class DaoContatos {
    fun listaContatos():ArrayList<Contato>{
        val list: ArrayList<Contato> = ArrayList()
        list.add(Contato(
            "Fulano da Silva",
            "fulano@email.com",
            "(11)52234-1234",
            "R. Reinaldo Denis, 390. Jd. Colúmbia. Mauá/SP",
            "minhafoto.jpg")
        )
        list.add(Contato(
            "Fulano da Silva 2",
            "fulano2@email.com",
            "(11)62234-1234",
            "Avenida Cap. João, 2301. Mauá/SP",
            "minhafoto2.jpg")
        )
        list.add(Contato(
            "Fulano da Silva 3",
            "fulano3@email.com",
            "(11)65894-1234",
            "Av. Antonia Rosa Fioravante, 804. Mauá/SP",
            "minhafoto3.jpg")
        )
        list.add(Contato(
            "Fulano da Silva 4",
            "fulano4@email.com",
            "(11)65894-4567",
            "R. Lucia Mormito Biassom, 150. Mauá/SP",
            "minhafoto4.jpg")
        )
        list.add(Contato(
            "Fulano da Silva 5",
            "fulano5@email.com",
            "(11)99999-1234",
            "Avenida Dom José Gaspar, 2129. Mauá/SP",
            "minhafoto5.jpg")
        )

        return list

    }
}