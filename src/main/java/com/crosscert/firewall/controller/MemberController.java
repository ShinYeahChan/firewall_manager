package com.crosscert.firewall.controller;

import com.crosscert.firewall.dto.MemberDTO;
import com.crosscert.firewall.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public String members (Model model) {
        List<MemberDTO.Response.Public> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/member/{id}")
    public String memberEdit(Model model, @PathVariable("id") Long id) {
        MemberDTO.Response.Public member = memberService.findMember(id);
        model.addAttribute("member", member);
        return "memberEdit";
    }
}
