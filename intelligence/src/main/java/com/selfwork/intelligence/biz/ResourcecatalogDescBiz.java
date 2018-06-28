package com.selfwork.intelligence.biz;

import com.github.pagehelper.Page;
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
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourcecatalogDescBiz extends BaseBiz {

    public final Logger logger = LoggerFactory.getLogger(getClass());
    //数据集说明内容
    @Autowired
    private DataSetDescPOMapper dataSetDescPOMapper;

    public Map<String, Object> findPage(CatalogDescQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {

            Page page = this.startPage(queryVo);
            List<DataSetDescPO> res = dataSetDescPOMapper.findList(queryVo);

            List<CatalogDescVo> list = BeanUtils.copyList(res, CatalogDescVo.class);
            result.put("total", page.getTotal());
            result.put("rows", list);
            return result;
        } catch (Exception e) {
            logger.error("获取数据集说明内容错误", e);
            return result;
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

    public CatalogDescVo selectByPrimaryKey(Integer id) {

        DataSetDescPO po = dataSetDescPOMapper.selectByPrimaryKey(id);

        if (po == null) {
            return null;
        }

        CatalogDescVo vo = new CatalogDescVo();
        BeanUtils.copy(po, vo);
        if (StringUtils.isEmpty(vo.getContent())) {
            vo.setContent("");
        }
        return vo;
    }


    public int edit(CatalogDescVo vo) {

        DataSetDescPO po = new DataSetDescPO();
        BeanUtils.copy(vo, po);
        return dataSetDescPOMapper.updateByPrimaryKeyWithBLOBs(po);
    }
}
