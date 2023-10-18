package com.example.hellospringF.service;

import com.example.hellospringF.domain.Member;
import com.example.hellospringF.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // 각 테스트를 실행하기 전에 이 메소드를 사용함.
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach      // 테스트를 전부 실행하고나서 메소드가 돌려고 할 때마다 DB 값을 지워준다.
    public void afterEach() {
        memberRepository.clearStore();    // 테스트가 한번 끝날 때마다 멤버에 채워진 값을 지워줌.
    }

    @Test
    void 회원가입() {   //테스트 코드는 한글로 바꿔도 됨.
        // given    무언가 주어질 때
        Member member = new Member();
        member.setName("hello");

        // when     이걸 실행했을 때
        Long saveId = memberService.join(member);

        // then     결과가 나와야 한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {

        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*

        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }*/

        // then

    }

    @Test
    void 회원검색 () {
    }

    @Test
    void 회원() {
    }
}