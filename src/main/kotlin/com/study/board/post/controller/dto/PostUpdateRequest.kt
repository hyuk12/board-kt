package com.study.board.post.controller.dto

import com.study.board.post.service.dto.PostUpdateRequestDto

data class PostUpdateRequest(
    val title: String,
    val content: String,
    val updatedBy: String,
)

fun PostUpdateRequest.toDto() = PostUpdateRequestDto(
        title = title,
        content = content,
        updatedBy = updatedBy,
)


