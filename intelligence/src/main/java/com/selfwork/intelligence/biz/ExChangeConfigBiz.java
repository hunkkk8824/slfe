package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.mapper.ExchangerPOMapper;
import com.selfwork.intelligence.model.po.ExchangerPO;
import com.selfwork.intelligence.model.vo.exchangeConfig.ExchangeConfigQueryVo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // 查询
        int pageNumber = queryVo.getPageNumber();
        int pageSize = queryVo.getLimit();
        PageHelper.startPage(pageNumber, pageSize);
        List<ExchangerPO> list = exchangerPOMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取交换配置分页信息失败");
            return null;
        }
        return new PageInfo<>(list);
    }
}
