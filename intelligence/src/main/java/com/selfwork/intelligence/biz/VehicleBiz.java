package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.mapper.VehiclePOMapper;
import com.selfwork.intelligence.model.po.VehiclePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBiz extends BaseBiz {

    @Autowired
    private VehiclePOMapper vehiclePOMapper;//这里会报错，但是并不会影响

    public VehiclePO getByid(Integer id) {

        return vehiclePOMapper.selectByPrimaryKey(id);
    }

    public PageInfo<VehiclePO> getAll(int pagenum) {

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pagenum, 1);
        List<VehiclePO> list = vehiclePOMapper.selectAll();
        PageInfo<VehiclePO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
