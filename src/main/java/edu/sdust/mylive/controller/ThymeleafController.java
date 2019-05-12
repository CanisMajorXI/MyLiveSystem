package edu.sdust.mylive.controller;

import edu.sdust.mylive.model.Room;
import edu.sdust.mylive.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class ThymeleafController {

    @Resource
    private RoomService roomService = null;

    @GetMapping("/error")
    String error() {
        return "error";
    }

    @GetMapping("/home")
    String homepage() {
        return "homepage";
    }

    @GetMapping("/room/{roomid}")
    String rome(@PathVariable("roomid") Integer roomId, ModelMap modelMap) {
        Room room = roomService.selectByPrimaryKey(roomId);
        modelMap.put("room_name", room.getRoomName());
        modelMap.put("room_intro", room.getRoomIntro());
        return "room1";
    }
}
