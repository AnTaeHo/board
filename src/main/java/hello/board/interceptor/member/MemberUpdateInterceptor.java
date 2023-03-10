package hello.board.interceptor.member;

import hello.board.controller.member.session.SessionConst;
import hello.board.domain.member.entity.Member;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MemberUpdateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Member loginMember = findLoginMember(request);
        Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long id = Long.parseLong((String)pathVariables.get("memberId"));

        return loginMember.getId().equals(id);
    }

    private Member findLoginMember(HttpServletRequest request) {
        return (Member) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
    }
}
