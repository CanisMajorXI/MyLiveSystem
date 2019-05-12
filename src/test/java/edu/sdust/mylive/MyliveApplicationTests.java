package edu.sdust.mylive;

import edu.sdust.mylive.tools.UserTools;
import org.hibernate.validator.constraints.EAN;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyliveApplicationTests {

    @Resource
    private RedisTemplate redisTemplate = null;
    @Test
    public void contextLoads() {

    }

    @RequestMapping("/mytest1")
    @Test
    public void test1(HttpServletRequest request) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//// 登录名
//        System.out.println("Username:"
//                + securityContextImpl.getAuthentication().getName());
//// 登录密码，未加密的
//        System.out.println("Credentials:"
//                + securityContextImpl.getAuthentication().getCredentials());
//        WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl
//                .getAuthentication().getDetails();
//// 获得访问地址
//        System.out.println("RemoteAddress" + details.getRemoteAddress());
//// 获得sessionid
//        System.out.println("SessionId" + details.getSessionId());
//// 获得当前用户所拥有的权限
//        List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
//                .getAuthentication().getAuthorities();
//        for (GrantedAuthority grantedAuthority : authorities) {
//            System.out.println("Authority" + grantedAuthority.getAuthority());
//        }
      //  redisTemplate.opsForValue().set("mykey1","myvalue1");
    }

    @Test
    public void test2() {
        String s1 = "sda";
        String s2 = "sda";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

}
