package com.example.kboot.member

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/members")
class MemberResource {
    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun getMembers(): List<Member> = memberService.findAll()

    @GetMapping("search")
    fun getMembers(@RequestParam name: String): List<Member> = memberService.findByName(name)

    @PostMapping
    fun create(@RequestBody member: MemberDto) = memberService.save(member)

    @PutMapping("{seq}")
    fun update(@PathVariable seq: Long, @RequestBody member: MemberDto) = memberService.update(seq, member)

    @DeleteMapping("{seq}")
    fun delete(@PathVariable seq: Long) = memberService.delete(seq)

    @PostConstruct
    fun initMemberData() {
        val member = MemberDto("Gavin", "Kim", 10, "gavin@example.com")
        memberService.save(member)
        for (m in 1..10) {
            memberService.save(member.copy(firstName = "${member.firstName}$m", lastName = "${member.lastName}$m", age = member.age + m, email = "$m${member.email}"))
        }
    }
}