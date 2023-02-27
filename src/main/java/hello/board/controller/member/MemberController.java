package hello.board.controller.member;

import hello.board.controller.member.dto.req.LoginFormDto;
import hello.board.controller.member.dto.res.MemberResDto;
import hello.board.domain.member.entity.Member;
import hello.board.domain.member.entity.MemberRole;
import hello.board.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MemberController {

    private final MemberService memberService;

    //회원가입 화면 메서드
    @GetMapping("/login/join")
    public String joinForm(@ModelAttribute("member") Member member, Model model) {
        model.addAttribute("memberRoles", MemberRole.values());
        return "members/addMember";
    }

    //로그인 화면 메서드
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginFormDto form) {
        return "login/loginForm";
    }

    //멤버 상세정보 메서드
    @GetMapping("/member")
    public String findById(@RequestParam Long id, Model model) {
        Member findMember = memberService.findById(id);
        model.addAttribute("member", new MemberResDto(findMember));
        return "members/member";
    }

    //멤버 수정 화면 메서드
    @GetMapping("/member/edit")
    public String updateMember(@RequestParam Long id, Model model) {
        Member findMember = memberService.findById(id);
        model.addAttribute("member", new MemberResDto(findMember));
        return "members/editMember";
    }

}
