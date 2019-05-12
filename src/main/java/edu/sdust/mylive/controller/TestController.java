package edu.sdust.mylive.controller;

import edu.sdust.mylive.tools.UserTools;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("1")
    public void test1(HttpServletRequest request) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
// 登录名
        System.out.println("Username:"
                + securityContextImpl.getAuthentication().getName());
// 登录密码，未加密的
        System.out.println("Credentials:"
                + securityContextImpl.getAuthentication().getCredentials());
        WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl
                .getAuthentication().getDetails();
// 获得访问地址
        System.out.println("RemoteAddress" + details.getRemoteAddress());
// 获得sessionid
        System.out.println("SessionId" + details.getSessionId());
// 获得当前用户所拥有的权限
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
                .getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            System.out.println("Authority" + grantedAuthority.getAuthority());
        }
    }

    @GetMapping("2")
    public void test2(HttpServletRequest request, HttpSession session) {
        System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
//        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
//                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//        int i = 1;
        //System.out.println(UserTools.JudgeOnline(request));
    }
//    @GetMapping("3")
//    public void test3() {
//       // String s1 = "sda";
//        String s2 = new String("sda");
//        String s1 = new String("sda");
//       //System.out.println(s1 == s2);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//    }
}
