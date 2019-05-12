package edu.sdust.mylive.tools;

import edu.sdust.mylive.service.UserWebSocketService;
import org.springframework.security.core.context.SecurityContextImpl;

import javax.servlet.http.HttpServletRequest;

public class UserTools {

    public static boolean JudgeOnline(HttpServletRequest request) {
//        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
//                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//        String email = securityContextImpl.getAuthentication().getName();
//        UserWebSocketService socketService = new UserWebSocketService();
//        socketService.setEmail(email);
//        return UserWebSocketService.websocketSet.contains(socketService);
//        for(UserWebSocketService socketService : UserWebSocketService.websocketSet) {
//            if(socketService.getEmail().equals(email))return true;
//        }
      //  return false;
        return true;
    }
    public static int GetOnlineCount() {
        return UserWebSocketService.getOnlineCount();
    }
}
