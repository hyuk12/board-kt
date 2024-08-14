package com.study.board.post.service

import com.study.board.exception.PostNotDeletableException
import com.study.board.exception.PostNotFoundException
import com.study.board.post.repository.PostRepository
import com.study.board.post.service.dto.PostCreateRequestDto
import com.study.board.post.service.dto.PostDetailResponseDto
import com.study.board.post.service.dto.PostSearchRequestDto
import com.study.board.post.service.dto.PostSummaryResponseDto
import com.study.board.post.service.dto.PostUpdateRequestDto
import com.study.board.post.service.dto.toDetailResponseDto
import com.study.board.post.service.dto.toEntity
import com.study.board.post.service.dto.toSummaryResponseDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
) {
    @Transactional
    fun createPost(postCreateRequestDto: PostCreateRequestDto): Long {
        return postRepository.save(postCreateRequestDto.toEntity()).id
    }

    @Transactional
    fun updatePost(id: Long, requestDto: PostUpdateRequestDto): Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotFoundException()
        post.update(requestDto)
        return id
    }

    @Transactional
    fun deletePost(id: Long, deletedBy: String): Long {
        val post = postRepository.findByIdOrNull(id) ?: throw PostNotDeletableException()
        if (post.createdBy != deletedBy) {
            throw PostNotDeletableException()
        }
        postRepository.delete(post)
        return id
    }

    fun getPost(id: Long): PostDetailResponseDto {
        return postRepository.findByIdOrNull(id)?.toDetailResponseDto() ?: throw PostNotFoundException()
    }

    fun findPageBy(pageRequest: Pageable, postSearchRequestDto: PostSearchRequestDto): Page<PostSummaryResponseDto> {
        return postRepository.findAll(pageRequest).toSummaryResponseDto()
    }
}
