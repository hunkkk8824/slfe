package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.mapper.ResourceEtlLogPOMapper;
import com.selfwork.intelligence.model.po.ResourceEtlLogPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zzc on 2018/5/2.
 */
@Service
public class ResourceEtlLogBiz extends BaseBiz {

    @Autowired
    private ResourceEtlLogPOMapper mapper;

    public void asynSave(Integer id, String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ResourceEtlLogPO po = new ResourceEtlLogPO();
                po.setResourceId(String.valueOf(id));
                po.setLogContent(content);
            }
        }).start();
    }
}
