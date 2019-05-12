package edu.sdust.mylive.service;

import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/room/{roomId}/{isAnchor}")

@Service
public class RoomWebSocketService {
    private static int onlineCount = 0;
    private Integer roomId;
    private boolean isAnchor = false;
    public static final Map<Integer, Set<RoomWebSocketService>> socketMap = new ConcurrentHashMap<>();
    //private static final AtomicInteger connectionIds = new AtomicInteger(0);
    //public static final Map<String, Integer> countsInRooms = new ConcurrentHashMap<>();

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
        isAnchor = Boolean.parseBoolean(session.getPathParameters().get("isAnchor"));
        roomId = Integer.parseInt(session.getPathParameters().get("roomId"));
        if (socketMap.get(roomId) == null) {
            socketMap.put(roomId, new CopyOnWriteArraySet<>());
        }
        socketMap.get(roomId).add(this);
        //  rooms.get(roomId);

//        this.session = session;
//        String isA = session.getPathParameters().get("1");
//        if (isA.equals("0")) {
//            isAnchor = true;
//            Set<RoomWebSocketService> roomWebSocketServices = new CopyOnWriteArraySet<>();
//            roomWebSocketServices.add(this);
//            rooms.put(roomId, roomWebSocketServices);
//            countsInRooms.put(roomId,1);
//        } else {
//            rooms.get(roomId).add(this);
//
//        }
//        this.roomId = session.getPathParameters().get("0");
//        rooms.put(roomId,this);

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
        System.out.println("new connect! ,current online people: " + socketMap.get(roomId).size());

    }

    @OnClose
    public void onClose() {
        Set<RoomWebSocketService> set = socketMap.get(roomId);
        set.remove(this);
//        if (isAnchor) {
//            Set<RoomWebSocketService> set = rooms.get(roomId);
//            for (RoomWebSocketService roomWebSocketService : set) {
//                try {
//                    roomWebSocketService.session.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//        int count = 0;
//        for (UserWebSocketService socketService : websocketSet) {
//            if (socketService.getEmail().equals(email)) {
//                websocketSet.remove(socketService);
//            }
//        }
//        subOnlineCount(1);
        System.out.println("one of the connection has closed,current online people " + socketMap.get(roomId).size());

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        session.getOpenSessions();
        for (RoomWebSocketService socketService : socketMap.get(roomId)) {
            try {
                socketService.session.getBasicRemote().sendText(message);
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

