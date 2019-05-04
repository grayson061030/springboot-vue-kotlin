package com.example.kboot.member

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MemberDto(
        val firstName: String,
        val lastName: String,
        val age: Int,
        val email: String?=null
)