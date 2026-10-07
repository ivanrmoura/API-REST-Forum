package br.com.forum.forumapi.repositories

import br.com.forum.forumapi.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long > {

}