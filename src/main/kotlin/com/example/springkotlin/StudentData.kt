package com.example.springkotlin

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.OffsetDateTime

@Entity
@Table(name = "student")
data class StudentData (

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @Column(name = "full_name")
    val fullName: String?,

    @Column(name = "nick_name")
    val nickName: String?,

    @Column(name = "email")
    val email: String?,

    @Column(name = "address")
    val address: String?,

    @Column(name = "city")
    val city: String?,

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: OffsetDateTime? = null,

    @Column(name = "created_by")
    val createdBy: String?,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: OffsetDateTime? = null,

    @Column(name = "updated_by")
    val updatedBy: String?,
)
