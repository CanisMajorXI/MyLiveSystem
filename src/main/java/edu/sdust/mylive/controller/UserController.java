package edu.sdust.mylive.controller;

import com.sun.mail.util.MailSSLSocketFactory;
import edu.sdust.mylive.model.UserLoginInfo;
import edu.sdust.mylive.service.UserLoginInfoService;
import javafx.util.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Properties;
import java.util.Random;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserLoginInfoService userLoginInfoService = null;

//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(@RequestParam("email") String email,
//                        @RequestParam("password") String password, HttpSession session) {
//        try {
//            if (email == null || password == null) throw new Exception("wrongpara");
//            User user = userService.login(email, password);
//            if (user == null) return "false";
//            session.setAttribute("user", user);
//
//            return "true";
//        } catch (Exception e) {
//            if (e.getMessage().equals("wrongpara")) return e.getMessage();
//            e.printStackTrace();
//            return "error";
//        }
//    }

//    @RequestMapping(value = "/status", produces = "application/json;charset=utf-8")
//    @ResponseBody
//    public String status(HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) return "{\"status\":false}";
//        return "{\"status\":true,\"nickname\":\"" + user.getNickname() + "\"}";
//    }

//    @RequestMapping("/logout")
//    @ResponseBody
//    public String logout(HttpSession session) {
//        try {
//            session.removeAttribute("user");
//            return "done";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//    }

    @GetMapping("/register/code")
    @ResponseBody
    public String getCode(@RequestParam("email") String email,
                          HttpSession session) {
        if (email == null || !isEmailTypeValid(email)) return "wrongpara";
        int code = getRandomCode();
        if (sendCodeToEmail(email, code)) {
            session.setAttribute("verificationCode", new Pair<>(email, code));
            return "done";
        }
        return "error";
    }

    @GetMapping("/register/isnotduplicate")
    @ResponseBody
    public boolean isNotDuplicate(@RequestParam(value = "email") String email) {

        if (email == null || !isEmailTypeValid(email)) {
            return false;
        }
        try {
            return userLoginInfoService.selectByPrimaryKey(email) == null;
            //    return userService.isNotDuplicate(email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/register/user")
    @ResponseBody
    public String addAnUser(@RequestParam(name = "email") String email,
                            @RequestParam(name = "password") String password,
                            @RequestParam(name = "code") Integer code, HttpSession session) {
        try {
            if (email == null || password == null || !isEmailTypeValid(email)) throw new Exception("wrongpara");
            Pair<String, Integer> pair = (Pair<String, Integer>) session.getAttribute("verificationCode");
            if (session.getAttribute("verificationCode") == null || pair == null ||
                    !pair.getKey().equals(email) || !pair.getValue().equals(code))
                throw new Exception("wrongcode");
            System.out.println(password);
            userLoginInfoService.insert(new UserLoginInfo(email, new BCryptPasswordEncoder().encode(password), true));
            return "done";
        } catch (Exception e) {
            if (e.getMessage().equals("wrongpara")) return e.getMessage();
            if (e.getMessage().equals("wrongcode")) return e.getMessage();
            e.printStackTrace();
            return "error";
        }
    }

    private boolean isEmailTypeValid(String email) {
        return email.matches("\\w+(.\\w+)*@\\w+(.\\w+)+");
    }

    private int getRandomCode() {
        return new Random().nextInt(899999) + 100000;
    }

    //发送验证码到邮箱
    private boolean sendCodeToEmail(String email, int code) {

        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        String from = "513768474@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);


            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("513768474@qq.com", "inivhogfaitibhed"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("维尼直播验证码");
            // 2.4设置邮件内容
            String content = "<html><head></head><body><h1>你的验证码是:" + code + "</h1>请在3分钟内输入该验证码完成注册</body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
