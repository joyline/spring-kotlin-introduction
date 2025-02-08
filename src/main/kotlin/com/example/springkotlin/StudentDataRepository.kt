package com.example.springkotlin

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentDataRepository : JpaRepository<StudentData, Int> {

    fun findByEmail(email: String?): List<StudentData>?

}
