package com.study.board.comment.controller.dto

import com.study.board.comment.service.dto.CommentCreateRequestDto

data class CommentCreateRequest(
    val content: String,
    val createdBy: String,
)

fun CommentCreateRequest.toDto(): CommentCreateRequestDto {
    return CommentCreateRequestDto(
        content = content,
        createdBy = createdBy,
    )
}
