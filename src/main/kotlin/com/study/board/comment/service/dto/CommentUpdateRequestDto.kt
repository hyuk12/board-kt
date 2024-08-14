package com.study.board.comment.service.dto

data class CommentUpdateRequestDto(
    val content: String,
    val updatedBy: String,
)
