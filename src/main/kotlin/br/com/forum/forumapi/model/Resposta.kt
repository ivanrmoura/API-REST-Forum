package br.com.forum.forumapi.model

import java.time.LocalDateTime

class Resposta (
    val id: Long? = null,
    val mensagem: String,
    val autor: Usuario,
    val topico: Topico,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val solucao: Boolean = false
)