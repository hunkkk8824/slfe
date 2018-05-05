package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BaseException;
import com.selfwork.intelligence.common.enums.ResponseCodeTypeEnum;
import com.selfwork.intelligence.mapper.ExchangerEtlPOMapper;
import com.selfwork.intelligence.mapper.ExchangerPOMapper;
import com.selfwork.intelligence.model.po.ExchangerEtlPO;
import com.selfwork.intelligence.model.po.ExchangerPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.exchangeConfig.ExchangeEtlQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zzc on 2018/4/25.
 */
@Service
public class ExchangeEtlBiz {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExchangerEtlPOMapper exchangerEtlPOmapper;

    @Autowired
    private ExchangerPOMapper exchangerPOMapper;

    public void save(ExchangerEtlPO exchangerEtlPO, UserInfoPO loginUser) {
        exchangerEtlPO.setCreateUser(String.valueOf(loginUser.getUserid()));
        exchangerEtlPO.setCreateTime(new Date());
        exchangerEtlPO.setValid(Boolean.TRUE);
        exchangerEtlPOmapper.insertSelective(exchangerEtlPO);
    }

    public void edit(ExchangerEtlPO exchangerEtlPO, UserInfoPO loginUser) {
        exchangerEtlPO.setLastModifyUser(String.valueOf(loginUser.getUserid()));
        exchangerEtlPO.setLastModifyTime(new Date());
        int update = exchangerEtlPOmapper.updateByPrimaryKeySelective(exchangerEtlPO);
        if(update != 1){
            throw new BaseException(ResponseCodeTypeEnum.DATABASE_EXCEPTION.getValue(),ResponseCodeTypeEnum.DATABASE_EXCEPTION.getDisplayName());
        }
    }

    public PageInfo<ExchangerEtlPO> findPage(ExchangeEtlQueryVo queryVo) {
        int pageNumber = queryVo.getPageNumber();
        int pageSize = queryVo.getLimit();
        PageHelper.startPage(pageNumber, pageSize);
        List<ExchangerEtlPO> list = exchangerEtlPOmapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取交换配置分页信息失败");
            return null;
        }
        return new PageInfo<>(list);
    }

    public ExchangerEtlPO findById(Integer id) {
        return exchangerEtlPOmapper.selectByPrimaryKey(id);
    }

    /**
     * 根据前置机ID获取ETL配置信息
     * @param code
     * @return
     */
    public List<ExchangerEtlPO> findListByExchangeCode(String code){
        ExchangerPO exchangerPO = exchangerPOMapper.findByCode(code);
        ExchangeEtlQueryVo queryVo= new ExchangeEtlQueryVo();
        queryVo.setExchangerId(exchangerPO.getId());
        return exchangerEtlPOmapper.findList(queryVo);
    }
}
