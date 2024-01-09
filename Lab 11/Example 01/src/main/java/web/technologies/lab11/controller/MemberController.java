package web.technologies.lab11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab11.model.Member;
import web.technologies.lab11.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        final var newMember = memberService.addMember(member);
        return ResponseEntity.ok(newMember);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findMember(@PathVariable Long id) {
        final var member = memberService.findMember(id);
        return ResponseEntity.ok(member);
    }

}
