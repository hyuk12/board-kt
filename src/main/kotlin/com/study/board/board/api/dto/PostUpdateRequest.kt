package com.study.board.board.api.dto

data class PostUpdateRequest(
    val title: String,
    val content: String,
    val updatedBy: String,
)
