package com.study.board.comment.service

import com.study.board.comment.repository.CommentRepository
import com.study.board.comment.service.dto.CommentCreateRequestDto
import com.study.board.comment.service.dto.CommentUpdateRequestDto
import com.study.board.comment.service.dto.toEntity
import com.study.board.exception.CommentNotDeletableException
import com.study.board.exception.CommentNotFoundException
import com.study.board.exception.PostNotFoundException
import com.study.board.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService (
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
) {
    @Transactional
    fun createComment(postId: Long, commentCreateRequestDto: CommentCreateRequestDto): Long? {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException()
        return commentRepository.save(commentCreateRequestDto.toEntity(post)).id
    }

    @Transactional
    fun updateComment(commentId: Long, commentUpdateRequestDto: CommentUpdateRequestDto): Long? {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw CommentNotFoundException()
        comment.update(commentUpdateRequestDto)
        return comment.id
    }

    @Transactional
    fun deleteComment(commentId: Long, deletedBy: String): Long? {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw CommentNotFoundException()
        if (comment.createdBy != deletedBy) {
            throw CommentNotDeletableException()
        }
        commentRepository.delete(comment)
        return commentId
    }
}
