package web.technologies.lab11.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab11.model.Member;
import web.technologies.lab11.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(final Member member) {
        // Check if email is already registered
        Optional<Member> existingMember = memberRepository.findByEmail(member.getEmail());
        if (existingMember.isPresent()) {
            throw new IllegalStateException("Email already registered");
        }
        return memberRepository.save(member);
    }

    public Member findMember(final Long id) {
        return memberRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Member with id " + id + " does not exist"));
    }
}

