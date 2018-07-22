package com.selfwork.intelligence.datamining.DBSCAN;

import java.util.ArrayList;

/**
 * Dbscan基于密度的聚类算法测试类
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] args) {
        String pointStr = "2,2;3,1;3,4;3,14;5,3;8,3;8,6;9,8;10,4;10,7;10,10;10,14;11,13;12,8;12,15;14,7;14,9;14,15;15,8;";
        //簇扫描半径
        double eps = 3;
        //最小包含点数阈值
        int minPts = 3;

        DBSCANTool tool = new DBSCANTool(eps, minPts, pointStr);
        String result1= tool.dbScanCluster();
        ArrayList<ArrayList<Point>> result2= tool.dbScanClusterPoints();

    }
}
