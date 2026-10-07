package br.com.forum.forumapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Resposta (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var mensagem: String,

    @ManyToOne
    var autor: Usuario,

    @ManyToOne
    var topico: Topico,

    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    var solucao: Boolean = false
)