package com.example.springkotlin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateStudentRequest (
    @field:NotNull
    @field:NotBlank
    val fullName: String?,

    @field:NotNull
    @field:NotBlank
    val nickName: String?,

    @field:NotNull
    @field:NotBlank
    val email: String?,

    @field:NotNull
    @field:NotBlank
    val address: String?,

    @field:NotNull
    @field:NotBlank
    val city: String?
)
