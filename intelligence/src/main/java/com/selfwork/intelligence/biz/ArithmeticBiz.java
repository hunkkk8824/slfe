package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.datamining.DataMining_ACO.ACOTool;
import com.selfwork.intelligence.model.vo.ArithmeticVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zzc on 2018/7/22.
 */
@Service
public class ArithmeticBiz {
    public String arithmetic(ArithmeticVo vo) {
        int type = vo.getType();
        String result = null;
        switch(type){
            case 1:
                result = DataMining_ACO(vo.getArr());
                break;
            case 2:
                //...;
                break;
            default:
                //...;
                break;
        }
        return result;
    }

    /**
     * DataMining_ACO
     * @param arr
     * @return
     */
    private String DataMining_ACO(List<String> arr) {
        //蚂蚁数量
        int antNum;
        //蚁群算法迭代次数
        int loopCount;
        //控制参数
        double alpha;
        double beita;
        double p;
        double Q;

        antNum = 3;
        alpha = 0.5;
        beita = 1;
        p = 0.5;
        Q = 5;
        loopCount = 5;
        ACOTool tool = new ACOTool(arr, antNum, alpha, beita, p, Q);
        return tool.antStartSearching(loopCount);
    }
}
