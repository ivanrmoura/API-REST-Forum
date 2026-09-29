package br.com.forum.forumapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {


    @GetMapping
    fun hello(): String{
        return "Olá mundo!"
    }

    @GetMapping("/saudacao/{nome}")
    fun saudacao(
        @PathVariable("nome") nome: String
    ): String{
        return "olá, tudo bem $nome?"
    }

}