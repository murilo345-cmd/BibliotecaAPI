package br.sp.gov.etec.Biblioteca.controller

import br.sp.gov.etec.Biblioteca.model.Livro
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController {

    @PostMapping
    fun cadastrar(@RequestBody livro: Livro): ResponseEntity<Livro> =
        ResponseEntity.status(HttpStatus.CREATED).body(livro)
}
