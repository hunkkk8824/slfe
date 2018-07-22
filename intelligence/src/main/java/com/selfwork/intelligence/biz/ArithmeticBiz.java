package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.datamining.DBSCAN.DBSCANTool;
import com.selfwork.intelligence.datamining.DBSCAN.Point;
import com.selfwork.intelligence.datamining.DataMining_ACO.ACOTool;
import com.selfwork.intelligence.datamining.GA.GATool;
import com.selfwork.intelligence.datamining.KDTree.KDTreeTool;
import com.selfwork.intelligence.model.vo.ArithmeticVo;
import org.springframework.stereotype.Service;

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
                //...;
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
