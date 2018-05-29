package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.mapper.DataSetDescPOMapper;
import com.selfwork.intelligence.model.DataSetDescPO;
import com.selfwork.intelligence.model.vo.catalogdesc.CatalogDescQueryVo;
import com.selfwork.intelligence.model.vo.catalogdesc.CatalogDescVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourcecatalogDescBiz {

    public final Logger logger = LoggerFactory.getLogger(getClass());
    //数据集说明内容
    @Autowired
    private DataSetDescPOMapper dataSetDescPOMapper;

    public PageInfo<CatalogDescVo> findPage(CatalogDescQueryVo queryVo) {

        try {
            int pageNumber = queryVo.getPageNumber();
            int pageSize = queryVo.getLimit();
            PageHelper.startPage(pageNumber, pageSize);
            List<DataSetDescPO> res = dataSetDescPOMapper.findList(queryVo);

            List<CatalogDescVo> list = BeanUtils.copyList(res, CatalogDescVo.class);
            return new PageInfo<>(list);
        } catch (Exception e) {
            logger.error("获取数据集说明内容错误", e);
            return null;
        }

    }

    //获取游客模式内容
    public String getTouristContent(String dataSetCode) {

        DataSetDescPO item = dataSetDescPOMapper.selectByDataSetCode(dataSetCode);
        if (item != null) {
            return item.getContent();
        }

        return "";
    }
}
