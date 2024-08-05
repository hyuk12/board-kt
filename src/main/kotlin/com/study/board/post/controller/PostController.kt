package com.study.board.post.controller

import com.study.board.post.controller.dto.PostCreateRequest
import com.study.board.post.controller.dto.PostDetailResponse
import com.study.board.post.controller.dto.PostSearchRequest
import com.study.board.post.controller.dto.PostSummaryResponse
import com.study.board.post.controller.dto.PostUpdateRequest
import com.study.board.post.controller.dto.toDto
import com.study.board.post.service.PostService
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
class PostController(
    private val postService: PostService,
) {

    @PostMapping("/posts")
    fun createPost(
        @RequestBody request: PostCreateRequest,
    ): Long {
        return postService.createPost(request.toDto())
    }

    @PutMapping("/posts/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @RequestBody request: PostUpdateRequest,
    ): Long {
        return postService.updatePost(id, request.toDto())
    }

    @DeleteMapping("/posts/{id}")
    fun deletePost(
        @PathVariable id: Long,
        @RequestParam deletedBy: String,
    ): Long {
        return postService.deletePost(id, deletedBy)
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
