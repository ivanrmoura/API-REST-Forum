package br.com.forum.forumapi.service

import br.com.forum.forumapi.dto.AtualizarTopicoRequest
import br.com.forum.forumapi.dto.CriarTopicoRequest
import br.com.forum.forumapi.dto.TopicoResponse
import br.com.forum.forumapi.dto.toResponse
import br.com.forum.forumapi.dto.toTopico
import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    private var topicos = mutableListOf<Topico>()

    init {
        val topico1 = Topico(
            id = 1,
            autor = usuarioService.buscarPorId(1),
            curso = cursoService.buscarPorId(1),
            mensagem = "Como criar um botão com compose",
            titulo = "Criação de botão"
        )

        val topico2 = Topico(
            id = 2,
            autor = usuarioService.buscarPorId(2),
            curso = cursoService.buscarPorId(2),
            mensagem = "Como criar uma variável",
            titulo = "Variavél em Kotlin"
        )
        topicos.add(topico1)
        topicos.add(topico2)
    }

    fun listar(): List<TopicoResponse>{
        return topicos.map { it.toResponse() }
    }

     fun buscarPorId(id: Long): TopicoResponse{
         val topico = topicos.find{  it.id == id }
             ?: throw NotFoundException("Topico de id $id não existe!")


         return topico.toResponse()
    }


    fun criarTopico(topicoDto: CriarTopicoRequest): TopicoResponse{
        val curso = cursoService.buscarPorId(topicoDto.curso)
        val autor = usuarioService.buscarPorId(topicoDto.autor)

        val topico = topicoDto.toTopico(
            curso = curso,
            autor = autor
        )

        topico.id = (topicos.size+1).toLong()
        topicos.add(topico)

        return topico.toResponse()
    }

    fun atualizarTopico(
        atualizarTopicoRequest: AtualizarTopicoRequest
    ): TopicoResponse{

        val index = topicos.indexOfFirst{it.id == atualizarTopicoRequest.id}

        if(index == -1){
            throw NotFoundException("Topico de id ${atualizarTopicoRequest.id} não existe!")
        }

        val topicoAtualizado = topicos[index].copy(
            titulo = atualizarTopicoRequest.titulo,
            mensagem = atualizarTopicoRequest.mensagem,
        )

        topicos[index] = topicoAtualizado


        return topicoAtualizado.toResponse()
    }


    fun deletarTopico(id: Long){
        val removeu = topicos.removeIf { t -> t.id == id }

        if (!removeu){
            throw NotFoundException("Topico de id $id não existe!")
        }

    }


}