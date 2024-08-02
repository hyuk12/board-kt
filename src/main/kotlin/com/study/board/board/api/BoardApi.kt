package com.study.board.board.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/boards")
class BoardApi {

    @GetMapping
    fun getBoards(): String {
        return "boards"
    }
}