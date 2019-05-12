package edu.sdust.mylive.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.sockjs.client.WebSocketClientSockJsSession;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/ws")
@Service
public class TestWebSocketService {
    private static int onlineCount = 0;
    //  public static CopyOnWriteArraySet<UserWebSocketService> websocketSet = new CopyOnWriteArraySet<>();
    private Session session = null;
//    private String email = "";
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
//        this.email = session.getUserPrincipal().getName();
//        boolean found = false;
//        for (Session curSession : session.getOpenSessions()) {
//            curSession.getUserPrincipal().getName();
//            if (socketService.getEmail().equals(this.email)) {
//                found = true;
//                break;
//            }
//        }
//        websocketSet.add(this);
//        if (!found) addOnlineCount(1);
        System.out.println("new connect! ,current online people: " + getOnlineCount());

    }

    @OnClose
    public void onClose() {
        int i = 1;
//        int count = 0;
//        for (UserWebSocketService socketService : websocketSet) {
//            if (socketService.getEmail().equals(email)) {
//                websocketSet.remove(socketService);
//            }
//        }
//        subOnlineCount(1);
//        System.out.println("one of the connection has closed,current online people " + getOnlineCount());

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        session.getOpenSessions();
//        WebSocketContainer webSocketContainer= new WebSocketContainer() {
//        WebSocketSession socketSession = new W
//        System.out.println("new message   :" + message);
//        for (UserWebSocketService item : websocketSet) {
//            try {
//
//                //     System.out.println(item.session.getRequestURI().getHost());
//                System.out.println(item.session.getUserPrincipal().getName());
//                item.sendMessage("收到！！！！！！！！！");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @OnError
    public void onError(Session session, Throwable err) {
        System.out.println("error!");
        //  session.getOpenSessions();
        err.printStackTrace();

    }

    private void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
        //   session.get
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }


//    private static synchronized void addOnlineCount(int n) {
//        UserWebSocketService.onlineCount += n;
//    }
//
//    private static synchronized void subOnlineCount(int n) {
//        UserWebSocketService.onlineCount -= n;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof UserWebSocketService)) return false;
//        return email.equals(((UserWebSocketService) obj).getEmail());
//    }


//        String email1 = this.session.getUserPrincipal().getName();
//        String email2 = ((UserWebSocketService) obj).session.getUserPrincipal().getName();
//        return email1.equals(email2);
}

