package com.study.board.comment.controller.dto

data class CommentCreateRequest(
    val content: String,
    val createdBy: String,
)
