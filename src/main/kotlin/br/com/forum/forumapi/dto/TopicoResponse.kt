package br.com.forum.forumapi.dto

import br.com.forum.forumapi.model.StatusTopico
import br.com.forum.forumapi.model.Topico
import java.time.LocalDateTime

class TopicoResponse (
    val id: Long?,
    val mensagem: String,
    val titulo: String,
    val dataCriacao: LocalDateTime,
    val statusTopico: StatusTopico
)

fun Topico.toResponse(): TopicoResponse {
    val topicoResponse = TopicoResponse(
        id = this.id,
        titulo = this.titulo,
        mensagem = this.mensagem,
        dataCriacao = this.dataCriacao,
        statusTopico = this.status
    )
    return topicoResponse
}