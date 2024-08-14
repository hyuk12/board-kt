package com.study.board.comment.controller.dto

import com.study.board.comment.service.dto.CommentUpdateRequestDto

data class CommentUpdateRequest(
    val content: String,
    val updatedBy: String,
)

fun CommentUpdateRequest.toDto(): CommentUpdateRequestDto {
    return CommentUpdateRequestDto(
        content = content,
        updatedBy = updatedBy,
    )
}
