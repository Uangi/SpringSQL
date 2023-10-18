package com.example.hellospringF.controller;

import java.util.List;

import com.example.hellospringF.domain.Member;
import com.example.hellospringF.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    // 스프링을 켜면 스프링 창과 컨테이너가 생기는데 @Controller 라는 어노테이션이 있다면
    // 멤버 컨트롤러라는 객체를 생성해서 스프링에 넣어두고 관리해줌.
    // 컴포넌트 스캔이라고 함. @Controller, @Repository, @Service

    private final MemberService memberService;

    @Autowired // 이걸 쓰면 스프링이 켜지면서 생성자를 호출해주는데 스프링 컨테이너에 있는 MemberService에 연결해준다.

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String  list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
