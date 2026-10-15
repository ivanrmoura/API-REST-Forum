package br.com.forum.forumapi.repositories

import br.com.forum.forumapi.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long > {


    fun findByCursoNomeContainingIgnoreCase(nomeCurso: String) : List<Topico>


    @Query("SELECT t FROM Topico t WHERE upper(t.curso.nome) like upper(concat('%',:nomeCurso, '%') ) ")
    fun findTopicoByCursoNameJPQL(nomeCurso: String): List<Topico>


    @Query("""SELECT t.* FROM topico t JOIN curso c 
        ON t.curso_id = c.id  
        WHERE upper(c.nome) LIKE  upper( concat('%', :nomeCurso, '%') )  
          """, nativeQuery = true)
    fun findTopicoByCursoNameSQL(nomeCurso: String, paginacao: Pageable): Page<Topico>

}