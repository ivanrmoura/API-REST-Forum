package br.com.forum.forumapi.dto

import br.com.forum.forumapi.model.Curso
import br.com.forum.forumapi.model.Topico
import br.com.forum.forumapi.model.Usuario
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CriarTopicoRequest (
    @NotEmpty
    @Size(min = 5, max = 100)
    val titulo: String,
    @NotEmpty
    val mensagem: String,
    @NotNull
    val curso: Long,
    @NotNull
    val autor: Long
)

fun CriarTopicoRequest.toTopico(
    curso: Curso,
    autor: Usuario
): Topico {
    val topico = Topico(
        mensagem = this.mensagem,
        titulo = this.titulo,
        curso = curso,
        autor = autor
    )
    return topico
}