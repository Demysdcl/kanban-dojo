package com.example.demo

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/boards")
class BoardController {

    @GetMapping
    fun all() = listOf(
            Board(1, "ABC"),
            Board(2, "Nexus"),
            Board(3, "iSCS")
    )

}