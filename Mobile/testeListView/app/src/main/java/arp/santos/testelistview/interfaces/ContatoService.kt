package arp.santos.testelistview.interfaces

import arp.santos.testelistview.models.Contato
import retrofit2.Call
import retrofit2.http.GET


interface ContatoService {

    @GET("contatos")
    fun getContatos(): Call<List<Contato>>

}