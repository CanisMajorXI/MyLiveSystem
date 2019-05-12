package edu.sdust.mylive.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import edu.sdust.mylive.model.UserLoginInfo;
import edu.sdust.mylive.dao.UserLoginInfoMapper;
import edu.sdust.mylive.model.UserLoginInfoExample;

import java.util.List;

@Service
public class UserLoginInfoService{

    @Resource
    private UserLoginInfoMapper userLoginInfoMapper;

    
    public long countByExample(UserLoginInfoExample example) {
        return userLoginInfoMapper.countByExample(example);
    }

    
    public int deleteByExample(UserLoginInfoExample example) {
        return userLoginInfoMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(String email) {
        return userLoginInfoMapper.deleteByPrimaryKey(email);
    }

    
    public int insert(UserLoginInfo record) {
        return userLoginInfoMapper.insert(record);
    }

    
    public int insertSelective(UserLoginInfo record) {
        return userLoginInfoMapper.insertSelective(record);
    }

    
    public List<UserLoginInfo> selectByExample(UserLoginInfoExample example) {
        return userLoginInfoMapper.selectByExample(example);
    }

    
    public UserLoginInfo selectByPrimaryKey(String email) {
        return userLoginInfoMapper.selectByPrimaryKey(email);
    }

    
    public int updateByExampleSelective(UserLoginInfo record,UserLoginInfoExample example) {
        return userLoginInfoMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(UserLoginInfo record,UserLoginInfoExample example) {
        return userLoginInfoMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(UserLoginInfo record) {
        return userLoginInfoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserLoginInfo record) {
        return userLoginInfoMapper.updateByPrimaryKey(record);
    }

}
