package edu.sdust.mylive.dao;

import edu.sdust.mylive.model.RoleName;
import edu.sdust.mylive.model.RoleNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleNameMapper {
    long countByExample(RoleNameExample example);

    int deleteByExample(RoleNameExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleName record);

    int insertSelective(RoleName record);

    List<RoleName> selectByExample(RoleNameExample example);

    RoleName selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") RoleName record, @Param("example") RoleNameExample example);

    int updateByExample(@Param("record") RoleName record, @Param("example") RoleNameExample example);

    int updateByPrimaryKeySelective(RoleName record);

    int updateByPrimaryKey(RoleName record);
}