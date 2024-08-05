package com.study.board.board.entity

import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity(
    val createdBy: String,

) {
    val createdAt: LocalDateTime = LocalDateTime.now()
    private var updatedBy: String? = null
    private var updatedAt: LocalDateTime? = null

    fun update(updatedBy: String) {
        this.updatedBy = updatedBy
        this.updatedAt = LocalDateTime.now()
    }
}
