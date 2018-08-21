package br.fpf.codingdojo.kanban

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/boards")
@RestController
class BoardController {

    @GetMapping
    fun listAll(): List<Board> {
        return listOf()
    }

}
