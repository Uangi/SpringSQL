package com.example.hellospringF;

import com.example.hellospringF.repository.MemberRepository;
import com.example.hellospringF.repository.MemoryMemberRepository;
import com.example.hellospringF.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    /*@Bean   // 컴포넌트 스캔 없이 자바 코드로 직접 스프링 빈 등록하는 방법
    public MemberService memberService() {
        return new MemberService(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
