package edu.sdust.mylive.service;

import edu.sdust.mylive.dao.RoomMapper;
import edu.sdust.mylive.model.Room;
import edu.sdust.mylive.model.RoomExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomService {

    @Resource
    private RoomMapper roomMapper;


    public long countByExample(RoomExample example) {
        return roomMapper.countByExample(example);
    }


    public int deleteByExample(RoomExample example) {
        return roomMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(Integer roomid) {
        return roomMapper.deleteByPrimaryKey(roomid);
    }


    public int insert(Room record) {
        return roomMapper.insert(record);
    }


    public int insertSelective(Room record) {
        return roomMapper.insertSelective(record);
    }


    public List<Room> selectByExample(RoomExample example) {
        return roomMapper.selectByExample(example);
    }


    public Room selectByPrimaryKey(Integer roomid) {
        return roomMapper.selectByPrimaryKey(roomid);
    }


    public int updateByExampleSelective(Room record, RoomExample example) {
        return roomMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(Room record, RoomExample example) {
        return roomMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(Room record) {
        return roomMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Room record) {
        return roomMapper.updateByPrimaryKey(record);
    }

}

