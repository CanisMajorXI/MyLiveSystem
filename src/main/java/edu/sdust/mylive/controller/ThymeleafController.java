package edu.sdust.mylive.controller;

import edu.sdust.mylive.model.AnchorKey;
import edu.sdust.mylive.model.AnchorKeyExample;
import edu.sdust.mylive.model.Room;
import edu.sdust.mylive.model.RoomExample;
import edu.sdust.mylive.service.AnchorKeyService;
import edu.sdust.mylive.service.RoomService;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ThymeleafController {

    @Resource
    private RoomService roomService = null;
    @Resource
    private AnchorKeyService anchorKeyService = null;

    @GetMapping("/error")
    String error() {
        return "th-error";
    }

    @GetMapping("/index")
    String index(ModelMap modelMap) {
        RoomExample roomExample = new RoomExample();
        modelMap.put("rooms", roomService.selectByExample(roomExample));
        return "th-index";
    }

    @GetMapping("/home")
    String home() {
        return "th-home";
    }

    @GetMapping("/login")
    String login() {
        return "th-login";
    }

    @GetMapping("/test")
    String test() {
        return "thtest1";
    }

    @GetMapping("/setting")
    String setting(ModelMap modelMap,HttpSession session) {
        String email = getEmail(session);
        AnchorKeyExample anchorKeyExample = new AnchorKeyExample();
        anchorKeyExample.createCriteria().andEmailEqualTo(email);
        List<AnchorKey> anchorKeyList = anchorKeyService.selectByExample(anchorKeyExample);
        if(anchorKeyList.size() == 1) {
            modelMap.put("key",anchorKeyList.get(0).getKey());
        }
        return "th-setting";
    }

    @GetMapping("/room/{roomid}")
    String room(@PathVariable("roomid") Integer roomId, ModelMap modelMap) {
        Room room = roomService.selectByPrimaryKey(roomId);
        modelMap.put("room_name", room.getRoomName());
        modelMap.put("room_intro", room.getRoomIntro());
        modelMap.put("room_id", roomId);
        return "th-room";
    }

    private String getEmail(HttpSession httpSession) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        return securityContextImpl.getAuthentication().getName();
    }
}
