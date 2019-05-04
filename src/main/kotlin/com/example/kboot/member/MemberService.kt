package com.example.kboot.member

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun findAll() = memberRepository.findAll()
    fun findByName(name: String) = memberRepository.findByFirstNameOrLastName(name, name)
    fun save(memberDto: MemberDto): MemberDto = memberRepository.save(Member.fromDto(memberDto)).toDto()
    fun findBySeq(seq:Long): MemberDto? {
        val member:Member = memberRepository.findById(seq).orElse(null)
        if (member == null ) return null else return member.toDto()
    }
    fun update(seq: Long, updateMemberDto: MemberDto): MemberDto? {
        val currentMember = memberRepository.findById(seq)
        return if (currentMember != null) memberRepository.save(Member.fromDto(updateMemberDto, currentMember.get())).toDto()
        else null
    }

    fun delete(seq: Long) = memberRepository.deleteById(seq)
}