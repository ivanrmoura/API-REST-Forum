package br.com.forum.forumapi.repositories

import br.com.forum.forumapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository


interface UsuarioRepository: JpaRepository<Usuario, Long> {
}