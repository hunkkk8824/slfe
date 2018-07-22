package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.datamining.DBSCAN.DBSCANTool;
import com.selfwork.intelligence.datamining.DBSCAN.Point;
import com.selfwork.intelligence.datamining.DataMining_ACO.ACOTool;
import com.selfwork.intelligence.datamining.DataMining_CABDDCC.CABDDCCTool;
import com.selfwork.intelligence.datamining.DataMining_Chameleon.ChameleonTool;
import com.selfwork.intelligence.datamining.DataMining_RandomForest.RandomForestTool;
import com.selfwork.intelligence.datamining.GA.GATool;
import com.selfwork.intelligence.datamining.KDTree.KDTreeTool;
import com.selfwork.intelligence.model.vo.ArithmeticVo;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
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
            case 5:
                result = DBSCAN(vo.getArr().get(0));
                break;
            case 6:
                result = GA(vo.getArr().get(0));
                break;
            case 7:
                result = GA_Maze(vo.getArr().get(0));
                break;
            case 8:
                result = KDTree(vo.getArr().get(0));
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

    private  String DBSCAN(String input){
        //簇扫描半径
        double eps = 3;
        //最小包含点数阈值
        int minPts = 3;

        DBSCANTool tool = new DBSCANTool(eps, minPts, input);
        return  tool.dbScanCluster();
    }

    private  String GA(String input){
        GATool tool = new GATool(input);
        return tool.geneticCal();
    }

    private String GA_Maze(String input){
        com.selfwork.intelligence.datamining.GA_Maze.GATool tool = new com.selfwork.intelligence.datamining.GA_Maze.GATool(input);
       return tool.goOutMaze();
    }

    private String KDTree(String input){
        String[] inputStrs = input.split("\\|");
        KDTreeTool tool = new KDTreeTool(inputStrs[1]);

        // 进行KD树的构建
        tool.createKDTree();

        // 通过KD树进行数据点的最近点查询
        String[] pointStr = inputStrs[0].split(",");
        com.selfwork.intelligence.datamining.KDTree.Point queryNode = new com.selfwork.intelligence.datamining.KDTree.Point(Double.parseDouble(pointStr[0]), Double.parseDouble(pointStr[1]));
        com.selfwork.intelligence.datamining.KDTree.Point searchedNode = tool.searchNearestData(queryNode);

        return MessageFormat.format(
                "距离查询点({0}, {1})最近的坐标点为({2}, {3})", queryNode.x, queryNode.y,
                searchedNode.x, searchedNode.y);
    }
}
