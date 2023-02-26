package hello.board.controller.home;

import hello.board.argumentresolver.Login;
import hello.board.domain.member.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //홈 화면 메서드
    @GetMapping("/home")
    public String homeLoginV3ArgumentResolver(@Login Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home/home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "home/loginHome";
    }
}
