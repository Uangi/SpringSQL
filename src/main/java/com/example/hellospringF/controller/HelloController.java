package com.example.hellospringF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IAttribute;

@Controller
public class HelloController {

    @GetMapping("hello")       // 웹 어플리케이션에서 /hello라고 들어오면 아래 메소드를 호출해줌.
   public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";

   }

   @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-templates";
    }

    @GetMapping("hello-string")
    @ResponseBody //바디부에 리턴하려는 내용을 직접 넣어주겠다. 요청한 클라이언트에 그대로 적힘.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + " " + name; //
    }

    @GetMapping("hello-api")    // json 방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {   // property 방식 : name에 바로 접근하기 어려우니 메소드 방식으로 접근하는 방식
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }


}

 