package edu.sdust.mylive.service;

import edu.sdust.mylive.model.UserBasicInfo;
import edu.sdust.mylive.model.UserBasicInfoExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/room/{roomId}")

@Service
public class RoomWebSocketService {
    @Resource
    UserBasicInfoService userBasicInfoService = null;
    private static int onlineCount = 0;
    private Integer roomId;
    private static final Map<Integer, Set<Session>> roomMap = new ConcurrentHashMap<>();
    //private static final AtomicInteger connectionIds = new AtomicInteger(0);
    //public static final Map<String, Integer> countsInRooms = new ConcurrentHashMap<>();
    private static final Map<String,String>nicknameMap = new HashMap<>();
    //  public static CopyOnWriteArraySet<UserWebSocketService> websocketSet = new CopyOnWriteArraySet<>();
    private Session session = null;


    @OnOpen
    public void onOpen(Session session) {
       // isAnchor = Boolean.parseBoolean(session.getPathParameters().get("isAnchor"));
        roomId = Integer.parseInt(session.getPathParameters().get("roomId"));
        if (roomMap.get(roomId) == null) {
            roomMap.put(roomId, new CopyOnWriteArraySet<>());
        }
//        String email = session.getUserPrincipal().getName();
//        UserBasicInfoExample userBasicInfoExample = new UserBasicInfoExample();
//        userBasicInfoExample.createCriteria().andEmailEqualTo(email);
//        System.out.println("email" + email);
//        UserBasicInfo userBasicInfo = userBasicInfoService.selectByPrimaryKey(email);
//        List<UserBasicInfo>userBasicInfoList = userBasicInfoService.selectByExample(userBasicInfoExample);
//        if(userBasicInfoList.size() == 1) {
          nicknameMap.put("513768474@qq.com","陈婷润");
          nicknameMap.put("2639376258@qq.com","冯旭阳");
//        }
        roomMap.get(roomId).add(session);
        System.out.println("new connect! ,current online people: " + roomMap.get(roomId).size());

    }

    @OnClose
    public void onClose(Session session) {
        Set<Session> set = roomMap.get(roomId);
        set.remove(session);
        System.out.println("one of the connection has closed,current online people " + roomMap.get(roomId).size());

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        String email = session.getUserPrincipal().getName();
        String nickname = nicknameMap.get(email);
        message = nickname + "说: "+message;
      //  session.getOpenSessions();
        for (Session recvSession : roomMap.get(roomId)) {
            try {
                recvSession.getBasicRemote().sendText(message);
                //socketService.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
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

//    public static synchronized int getOnlineCount(String roomId) {
//        return countsInRooms.get(roomId);
//    }
//
//
//    private static synchronized void addOnlineCount(String roomId) {
//        countsInRooms.put(roomId, countsInRooms.get(roomId) + 1);
//    }
//
//    private static synchronized void subOnlineCount(String roomId) {
//        countsInRooms.put(roomId, countsInRooms.get(roomId) - 1);
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

