package br.com.forum.forumapi.service

import br.com.forum.forumapi.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    private val usuarios = mutableListOf<Usuario>()

    init {
        val usuario1 = Usuario(
            id = 1,
            nome = "Lucas",
            email = "lucas@email.com"
        )

        val usuario2 = Usuario(
            id = 2,
            nome = "Júlia Maria",
            email = "julia@email.com"
        )

        usuarios.add(usuario1)
        usuarios.add(usuario2)

    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.first { it.id == id }
    }




}