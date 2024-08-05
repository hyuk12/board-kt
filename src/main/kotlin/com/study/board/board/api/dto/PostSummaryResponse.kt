package com.study.board.board.api.dto

data class PostSummaryResponse(
    val id: Long,
    val title: String,
    val createdBy: String,
    val createdAt: String,
    val tag: String? = null,
    val likeCount: Long = 0,
)
