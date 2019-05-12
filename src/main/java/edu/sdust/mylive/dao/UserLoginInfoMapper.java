package edu.sdust.mylive.dao;

import edu.sdust.mylive.model.UserLoginInfo;
import edu.sdust.mylive.model.UserLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginInfoMapper {
    long countByExample(UserLoginInfoExample example);

    int deleteByExample(UserLoginInfoExample example);

    int deleteByPrimaryKey(String email);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    List<UserLoginInfo> selectByExample(UserLoginInfoExample example);

    UserLoginInfo selectByPrimaryKey(String email);

    int updateByExampleSelective(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByExample(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);
}