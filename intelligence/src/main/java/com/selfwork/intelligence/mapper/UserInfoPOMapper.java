package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoPOMapper {

    /**
     * 列表查询
     * @param userQueryDto
     * @return
     */
    List<UserInfoPO> findList(UserQueryVo userQueryDto);

    List<UserInfoPO> findUserByAccountOrCallPhone(@Param("userName") String userName);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    UserInfoPO selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}