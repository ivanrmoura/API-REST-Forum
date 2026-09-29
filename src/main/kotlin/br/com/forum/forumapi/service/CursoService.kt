package br.com.forum.forumapi.service

import br.com.forum.forumapi.model.Curso
import br.com.forum.forumapi.model.Usuario
import org.springframework.stereotype.Service

@Service
class CursoService {

    private val cursos = mutableListOf<Curso>()

    init {
        val curso1 = Curso(
           id = 1,
            nome = "Android Developer",
            categoria = "Mobile"
        )

        val curso2 = Curso(
            id = 2,
            nome = "Kotlin Developer",
            categoria = "Programação"
        )

        cursos.add(curso1)
        cursos.add(curso2)
    }

    fun buscarPorId(id: Long): Curso {
        return  cursos.first{ it.id == id}
    }



}