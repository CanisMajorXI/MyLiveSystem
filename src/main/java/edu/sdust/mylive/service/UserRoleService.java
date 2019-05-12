package edu.sdust.mylive.service;

import edu.sdust.mylive.dao.RoleNameMapper;
import edu.sdust.mylive.model.RoleName;
import edu.sdust.mylive.model.RoleNameExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import edu.sdust.mylive.model.UserRole;
import edu.sdust.mylive.model.UserRoleExample;
import edu.sdust.mylive.dao.UserRoleMapper;

import java.util.List;

@Service
public class UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleNameMapper roleNameMapper;

    
    public long countByExample(UserRoleExample example) {
        return userRoleMapper.countByExample(example);
    }

    
    public int deleteByExample(UserRoleExample example) {
        return userRoleMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    
    public List<UserRole> selectByExample(UserRoleExample example) {
        return userRoleMapper.selectByExample(example);
    }

    
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(UserRole record,UserRoleExample example) {
        return userRoleMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(UserRole record,UserRoleExample example) {
        return userRoleMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }


    public List<RoleName> selectRoleNamesByEmail(String email) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andEmailEqualTo(email);
        RoleNameExample roleNameExample = new RoleNameExample();
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        for (UserRole userRole : userRoles) {
            roleNameExample.or().andRoleIdEqualTo(userRole.getRoleId());
        }
        return roleNameMapper.selectByExample(roleNameExample);
    }
}
