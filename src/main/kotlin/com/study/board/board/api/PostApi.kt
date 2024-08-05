package com.study.board.board.api

import com.study.board.board.api.dto.PostCreateRequest
import com.study.board.board.api.dto.PostDetailResponse
import com.study.board.board.api.dto.PostSearchRequest
import com.study.board.board.api.dto.PostSummaryResponse
import com.study.board.board.api.dto.PostUpdateRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class PostApi {

    @PostMapping("/posts")
    fun createPost(
        @RequestBody request: PostCreateRequest,
    ): Long {
        return 1L
    }

    @PutMapping("/posts/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @RequestBody request: PostUpdateRequest,
    ): Long {
        return id
    }

    @DeleteMapping("/posts/{id}")
    fun deletePost(
        @PathVariable id: Long,
        @RequestParam createdBy: String,
    ): Long {
        println(createdBy)
        return id
    }

    @GetMapping("/posts/{id}")
    fun getPost(
        @PathVariable id: Long,
    ): PostDetailResponse {
        return PostDetailResponse(
            id = id,
            title = "title",
            content = "content",
            createdBy = "createdBy",
            createdAt = LocalDateTime.now().toString()
        )
    }

    @GetMapping("/posts")
    fun getPosts(
        pageable: Pageable,
        postSearchRequest: PostSearchRequest,
    ): Page<PostSummaryResponse> {
        println("title: ${postSearchRequest.title}")
        println("createdBy: ${postSearchRequest.createdBy}")
        println("tag: ${postSearchRequest.tag}")
        return Page.empty()
    }
}
