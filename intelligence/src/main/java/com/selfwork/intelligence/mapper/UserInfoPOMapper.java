package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoPOMapper {

    List<UserInfoPO> findUserByAccountOrCallPhone(@Param("userName") String userName);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    UserInfoPO selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}