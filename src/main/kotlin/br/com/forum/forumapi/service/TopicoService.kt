package br.com.forum.forumapi.service

import br.com.forum.forumapi.dto.AtualizarTopicoRequest
import br.com.forum.forumapi.dto.CriarTopicoRequest
import br.com.forum.forumapi.dto.TopicoResponse
import br.com.forum.forumapi.dto.toResponse
import br.com.forum.forumapi.dto.toTopico
import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.model.Topico
import br.com.forum.forumapi.repositories.TopicoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoRepository: TopicoRepository
) {

    fun listar(): List<TopicoResponse>{
        val topicos = topicoRepository.findAll()
        return topicos.map{ it.toResponse() }
    }

     fun buscarTopicoPorId(id: Long): Topico{
         val topico = topicoRepository.findById(id)
             .orElseThrow{ NotFoundException("Topico de id $id não encontrado") }
         return topico
    }

    fun buscarTopicoResponsePorId(id: Long): TopicoResponse{
        return buscarTopicoPorId(id).toResponse()
    }


    @Transactional
    fun criarTopico(topicoDto: CriarTopicoRequest): TopicoResponse{
        val curso = cursoService.buscarPorId(topicoDto.curso)
        val autor = usuarioService.buscarPorId(topicoDto.autor)

        val topico = topicoDto.toTopico(
            curso = curso,
            autor = autor
        )

        topicoRepository.save(topico)

        return topico.toResponse()
    }

    @Transactional
    fun atualizarTopico(
        atualizarTopicoRequest: AtualizarTopicoRequest
    ): TopicoResponse{

        val topico = buscarTopicoPorId(atualizarTopicoRequest.id)

        topico.apply {
            titulo = atualizarTopicoRequest.titulo
            mensagem = atualizarTopicoRequest.mensagem
        }

        val topicoAtualizado = topicoRepository.save(topico)

       return topicoAtualizado.toResponse()
    }

        @Transactional
    fun deletarTopico(id: Long){

        if (!topicoRepository.existsById(id)){
            throw NotFoundException("Topico de id $id não existe!")
        }
        topicoRepository.deleteById(id)
    }


}