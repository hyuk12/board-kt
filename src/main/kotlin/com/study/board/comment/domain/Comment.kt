package com.study.board.comment.domain

import com.study.board.comment.service.dto.CommentUpdateRequestDto
import com.study.board.post.domain.BaseEntity
import com.study.board.post.domain.Post
import com.study.board.exception.CommentNotUpdatableException
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Comment(
    content: String,
    post: Post,
    createdBy: String,
) : BaseEntity(createdBy = createdBy) {

    fun update(updateRequestDto: CommentUpdateRequestDto) {
        if (updateRequestDto.updatedBy != createdBy) {
            throw CommentNotUpdatableException()
        }
        this.content = updateRequestDto.content
        super.updatedBy(updateRequestDto.updatedBy)

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var content: String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var post: Post = post
        protected set
}

