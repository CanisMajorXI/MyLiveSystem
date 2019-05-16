package edu.sdust.mylive.controller;

import edu.sdust.mylive.model.AnchorKey;
import edu.sdust.mylive.model.AnchorKeyExample;
import edu.sdust.mylive.service.AnchorKeyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class SrsController {

    @Resource
    AnchorKeyService anchorKeyService = null;

    @RequestMapping("/api/v1/clients")
    public int Test(@RequestBody Map<String, String> stringStringMap) {
        // System.out.println(str);
        int i = 1;
        //    System.out.println("收到client！");
        return 0;
    }

    @RequestMapping("/api/tt")
    public int Test7() {
        //System.out.println(str);
        System.out.println("收到client！");
        return 0;
    }

    @RequestMapping("/api/v1/streams")
    public int onStreams(@RequestBody Map<String, String> urlMap) {
        System.out.println("收到streams！");
        String param = urlMap.get("param");
        String pattern = "\\?email=(\\S+)&key=(\\w{10})";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(param);
        if (!matcher.find()) return 1;
        String email = matcher.group(1);
        String key = matcher.group(2);
        AnchorKeyExample anchorKeyExample = new AnchorKeyExample();
        anchorKeyExample.createCriteria().andEmailEqualTo(email).andKeyEqualTo(key);
        List<AnchorKey> anchorKeyList = anchorKeyService.selectByExample(anchorKeyExample);
        return -(anchorKeyList.size() - 1);
    }

    @RequestMapping("/api/v1/sessions")
    public int Test3(@RequestBody String str) {
        System.out.println(str);
        System.out.println("收到session！");
        return 0;
    }
}
