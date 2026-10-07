package br.com.forum.forumapi.service

import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.model.Curso
import br.com.forum.forumapi.model.Usuario
import br.com.forum.forumapi.repositories.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val cursoRepository: CursoRepository,
) {


    fun buscarPorId(id: Long): Curso {
        return  cursoRepository.findById(id)
            .orElseThrow { NotFoundException("Curso de id $id não existe!") }
    }



}