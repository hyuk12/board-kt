package com.study.board.board.api.dto

data class PostCreateRequest(
    val title: String,
    val content: String,
    val createdBy: String,
)
