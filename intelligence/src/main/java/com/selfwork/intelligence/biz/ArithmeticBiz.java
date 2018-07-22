package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.datamining.DataMining_ACO.ACOTool;
import com.selfwork.intelligence.datamining.DataMining_CABDDCC.CABDDCCTool;
import com.selfwork.intelligence.datamining.DataMining_Chameleon.ChameleonTool;
import com.selfwork.intelligence.datamining.DataMining_RandomForest.RandomForestTool;
import com.selfwork.intelligence.model.vo.ArithmeticVo;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
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
                result = DataMining_RandomForest(vo.getArr());
                break;
            case 3:
                result = DataMining_CABDDCC(vo.getArr());
                break;
            case 4:
                result = DataMining_Chameleon(vo.getArr());
                break;
            default:
                //...;
                break;
        }
        return result;
    }

    /**
     * DataMining_RandomForest
     * @param arr
     * @return
     */
    private String DataMining_RandomForest(List<String> arr) {
        String queryStr = "Age=Youth,Income=Low,Student=No,CreditRating=Fair";

        // 决策树的样本占总数的占比率
        double sampleNumRatio = 0.4;
        // 样本数据的采集特征数量占总特征的比例
        double featureNumRatio = 0.5;

        StringBuilder sb = new StringBuilder();

        RandomForestTool tool = new RandomForestTool(arr, sampleNumRatio,
                featureNumRatio);
        String str1 = tool.constructRandomTree();

        String resultClassType = tool.judgeClassType(queryStr);

        sb.append(str1);
        sb.append("\n");
        sb.append(MessageFormat.format(
                        "查询属性描述{0},预测的分类结果为BuysCompute:{1}", queryStr,
                        resultClassType));
        return sb.toString();
    }

    /**
     * DataMining_Chameleon
     * @param arr
     * @return
     */
    private String DataMining_Chameleon(List<String> arr) {
        //k-近邻的k设置
        int k = 1;
        //度量函数阈值
        double minMetric = 0.1;
        ChameleonTool tool = new ChameleonTool(arr, k, minMetric);
        return tool.buildCluster();
    }

    /**
     * DataMining_CABDDCC
     * @param arr
     * @return
     */
    private String DataMining_CABDDCC(List<String> arr) {
        //连通距离阈值
        int length = 3;

        CABDDCCTool tool = new CABDDCCTool(arr, length);
        return tool.splitCluster();
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
