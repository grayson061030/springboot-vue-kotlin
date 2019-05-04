package com.example.kboot.member

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun getMembers(@RequestParam name: String): ResponseEntity<List<Member>?> {
        val members = memberService.findByName(name)
        val status = if (members == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(members,status)
    }

    @PostMapping
    fun create(@RequestBody member: MemberDto) = memberService.save(member)

    @PutMapping("{seq}")
    fun update(@PathVariable seq: Long, @RequestBody member: MemberDto) = memberService.update(seq, member)

    @DeleteMapping("{seq}")
    fun delete(@PathVariable seq: Long): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (memberService.findBySeq(seq) != null) {
            memberService.delete(seq)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit,status)
    }

    @PostConstruct
    fun initMemberData() {
        val member = MemberDto("Gavin", "Kim", 10, "gavin@example.com")
        memberService.save(member)
        for (m in 1..10) {
            memberService.save(member.copy(firstName = "${member.firstName}$m", lastName = "${member.lastName}$m", age = member.age + m, email = "$m${member.email}"))
        }
    }
}