package com.study.board.comment.controller.dto

data class CommentResponse(
    val id: Long,
    val content: String,
    val createdBy: String,
    val createdAt: String,
)
