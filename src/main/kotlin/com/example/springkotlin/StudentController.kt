package com.example.springkotlin

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

@RestController
class StudentController @Autowired constructor(
    private val studentDataRepository: StudentDataRepository
) {

    @GetMapping("/student-list")
    fun getAllStudent(): ResponseEntity<List<StudentData>> {
        val result = studentDataRepository.findAll();
        return ResponseEntity.ok(result)
    }

    @GetMapping("/student/{studentId}")
    fun getStudentById(@PathVariable studentId: Int): ResponseEntity<StudentData?> {
        val result = studentDataRepository.findById(studentId).orElse(null)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/student")
    fun getStudentByEmail(@RequestParam email: String): ResponseEntity<List<StudentData>?> {
        val result = studentDataRepository.findByEmail(email)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/student")
    fun createStudent(@Valid @RequestBody request: CreateStudentRequest): ResponseEntity<StudentData?> {
        val studentData = StudentData(
            fullName = request.fullName,
            nickName = request.nickName,
            email = request.email,
            address = request.address,
            city = request.city,
            createdAt = OffsetDateTime.now(),
            createdBy = "admin",
            updatedAt = OffsetDateTime.now(),
            updatedBy = "admin"
        )

        val result = studentDataRepository.saveAndFlush(studentData)
        return ResponseEntity.ok(result)
    }
}
