package br.com.forum.forumapi.model

import java.time.LocalDateTime

data class Topico (
    var id: Long? = null,
    val autor: Usuario,
    val curso: Curso,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    val respostas: MutableList<Resposta> = mutableListOf()
)