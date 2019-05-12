package edu.sdust.mylive.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import edu.sdust.mylive.model.UserBasicInfo;
import edu.sdust.mylive.dao.UserBasicInfoMapper;
import edu.sdust.mylive.model.UserBasicInfoExample;

import java.util.List;

@Service
public class UserBasicInfoService{

    @Resource
    private UserBasicInfoMapper userBasicInfoMapper;

    
    public long countByExample(UserBasicInfoExample example) {
        return userBasicInfoMapper.countByExample(example);
    }

    
    public int deleteByExample(UserBasicInfoExample example) {
        return userBasicInfoMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return userBasicInfoMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserBasicInfo record) {
        return userBasicInfoMapper.insert(record);
    }

    
    public int insertSelective(UserBasicInfo record) {
        return userBasicInfoMapper.insertSelective(record);
    }

    
    public List<UserBasicInfo> selectByExample(UserBasicInfoExample example) {
        return userBasicInfoMapper.selectByExample(example);
    }

    
    public UserBasicInfo selectByPrimaryKey(Integer id) {
        return userBasicInfoMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(UserBasicInfo record,UserBasicInfoExample example) {
        return userBasicInfoMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(UserBasicInfo record,UserBasicInfoExample example) {
        return userBasicInfoMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(UserBasicInfo record) {
        return userBasicInfoMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserBasicInfo record) {
        return userBasicInfoMapper.updateByPrimaryKey(record);
    }

}
