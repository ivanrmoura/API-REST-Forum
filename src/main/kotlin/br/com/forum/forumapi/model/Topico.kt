package br.com.forum.forumapi.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
class Topico (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    var autor: Usuario,

    @ManyToOne
    var curso: Curso,

    var titulo: String,
    var mensagem: String,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @OneToMany(mappedBy = "topico")
    var respostas: MutableList<Resposta> = mutableListOf()
)