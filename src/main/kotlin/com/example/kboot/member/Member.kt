package com.example.kboot.member

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "MEMBER")
data class Member(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val memberSeq: Long? = null,

        @NotEmpty
        @Column(name = "first_name", nullable = false)
        val firstName: String,

        @NotEmpty
        @Column(name = "last_name", nullable = false)
        val lastName: String,

        @NotEmpty
        @Column(name = "age", nullable = false)
        val age: Int,

        @Email
        @NotEmpty
        @Column(name = "email", nullable = false)
        val email: String
) {
    fun toDto(): MemberDto = MemberDto(
            firstName = firstName,
            lastName = lastName,
            age = age,
            email = email
    )

    companion object {
        fun fromDto(dto: MemberDto) = Member(
                firstName = dto.firstName,
                lastName = dto.lastName,
                age = dto.age,
                email = dto.email!!
        )

        fun fromDto(updateMemberDto: MemberDto, currentMember: Member) = Member(
                memberSeq = currentMember.memberSeq!!,
                firstName = updateMemberDto.firstName,
                lastName = updateMemberDto.lastName,
                age = updateMemberDto.age,
                email = updateMemberDto.email!!
        )
    }

    override fun toString() = "Member(firstName=$firstName,lastName=$lastName,age=$age,email=$email)"

}
