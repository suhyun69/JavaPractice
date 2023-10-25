package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @DisplayName("회원가입")
    @Test
    public void 회원가입() throws Exception {

        // Given
        Member member = new Member();
        member.setName("kim");

        // When
        Long saveId = memberService.join(member);

        // Then
        assertThat(member).isEqualTo(memberRepository.findById(saveId).get());
    }

    @DisplayName("중복_회원_예외")
    @Test
    public void 중복_회원_예외() throws Exception {

        // Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // When
        memberService.join(member1);

        // Then
        try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
    }

}