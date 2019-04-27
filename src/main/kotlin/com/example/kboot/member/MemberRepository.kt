package com.example.kboot.member

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member,Long>{
    fun findByFirstNameOrLastName(firstName:String, lastName:String):List<Member>
}