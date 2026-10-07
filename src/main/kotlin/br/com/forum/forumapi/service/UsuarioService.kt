package br.com.forum.forumapi.service

import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.model.Usuario
import br.com.forum.forumapi.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
) {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id)
            .orElseThrow { NotFoundException("Usuário de id $id não existe!") }
    }




}