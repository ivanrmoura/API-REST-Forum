package br.com.forum.forumapi.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

class AtualizarTopicoRequest (
    @NotNull
    val id: Long?,
    @NotEmpty
    @Size(min = 5, max = 100)
    val titulo: String,
    @NotEmpty
    @Size(min = 5, max = 600)
    val mensagem: String


)