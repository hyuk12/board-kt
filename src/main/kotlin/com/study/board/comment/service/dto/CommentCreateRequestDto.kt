package com.study.board.comment.service.dto

import com.study.board.comment.domain.Comment
import com.study.board.post.domain.Post

data class CommentCreateRequestDto(
    val content: String,
    val createdBy: String,
)

fun CommentCreateRequestDto.toEntity(post: Post) = Comment(
    content = content,
    createdBy = createdBy,
    post = post,
)
