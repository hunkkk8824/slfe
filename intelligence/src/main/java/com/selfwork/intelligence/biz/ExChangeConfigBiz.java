package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BaseException;
import com.selfwork.intelligence.common.enums.ResponseCodeTypeEnum;
import com.selfwork.intelligence.mapper.ExchangerPOMapper;
import com.selfwork.intelligence.model.po.ExchangerPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.exchangeConfig.ExchangeConfigQueryVo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zzc on 2018/4/22.
 */
@Service
public class ExChangeConfigBiz extends BaseBiz {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
    @Autowired
    private ExchangerPOMapper exchangerPOMapper;

    public PageInfo<ExchangerPO> findPage(ExchangeConfigQueryVo queryVo) {

        this.startPage(queryVo);
        List<ExchangerPO> list = exchangerPOMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取交换配置分页信息失败");
            return null;
        }
        return new PageInfo<>(list);
    }

    public List<ExchangerPO> findAllEnable() {

        ExchangeConfigQueryVo queryVo = new ExchangeConfigQueryVo();
        queryVo.setValid(true);
        queryVo.setLimit(Integer.MAX_VALUE);
        queryVo.setOffset(1);
        PageInfo<ExchangerPO> pageInfo = this.findPage(queryVo);

        if (pageInfo != null) {
            return pageInfo.getList();
        } else {
            return null;
        }

    }

    public void save(ExchangerPO exchanger, UserInfoPO user) {
        exchanger.setCode(exchanger.getName());
        exchanger.setCreateTime(new Date());
        exchanger.setCreateUser(String.valueOf(user.getUserid()));
        exchanger.setValid(Boolean.TRUE);
        exchangerPOMapper.insertSelective(exchanger);
    }

    public ExchangerPO findById(Integer id) {
        return exchangerPOMapper.selectByPrimaryKey(id);
    }

    public void edit(ExchangerPO exchanger, UserInfoPO loginUser) {
        exchanger.setLastModifyTime(new Date());
        exchanger.setLastModifyUser(String.valueOf(loginUser.getUserid()));
        int update = exchangerPOMapper.updateByPrimaryKeySelective(exchanger);
        if (update != 1) {
            throw new BaseException(ResponseCodeTypeEnum.DATABASE_EXCEPTION.getValue(), ResponseCodeTypeEnum.DATABASE_EXCEPTION.getDisplayName());
        }
    }

    public ExchangerPO findByCode(String sourceExchangerCode) {
        return exchangerPOMapper.findByCode(sourceExchangerCode);
    }
}
