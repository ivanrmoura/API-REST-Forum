package br.com.forum.forumapi.controller

import br.com.forum.forumapi.dto.AtualizarTopicoRequest
import br.com.forum.forumapi.dto.CriarTopicoRequest
import br.com.forum.forumapi.dto.TopicoResponse
import br.com.forum.forumapi.model.Topico
import br.com.forum.forumapi.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listarTopicos(): List<TopicoResponse>{

        return topicoService.listar()
    }


    @GetMapping("/{id}")
    fun buscarPorId(
        @PathVariable id: Long
    ): TopicoResponse{
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun criarTopico(
        @RequestBody @Valid topicoDto: CriarTopicoRequest,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<TopicoResponse>{
        val topicoCriado = topicoService.criarTopico(topicoDto)

        val uri = uriBuilder.path("/topicos/${topicoCriado.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoCriado)
    }


    @PutMapping
    fun atualizarTopico(
        @Valid @RequestBody atualizarTopicoRequest: AtualizarTopicoRequest
    ) : ResponseEntity<TopicoResponse>{

        val topicoAtualizado = topicoService.atualizarTopico(atualizarTopicoRequest)

        return ResponseEntity.ok(topicoAtualizado)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deletarTopico(
       @PathVariable id: Long
    ){
        topicoService.deletarTopico(id)
    }


}