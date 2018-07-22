package com.selfwork.intelligence.datamining.KDTree;

import java.text.MessageFormat;

/**
 * KD树算法测试类
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] args) {
        String inputStr = "2.1,3.1|4,7;5,4;9,6;7,2;2,3;8,1";

        String[] inputStrs = inputStr.split("\\|");
        KDTreeTool tool = new KDTreeTool(inputStrs[1]);

        // 进行KD树的构建
        tool.createKDTree();

        // 通过KD树进行数据点的最近点查询
        String[] pointStr = inputStrs[0].split(",");
        Point queryNode = new Point(Double.parseDouble(pointStr[0]), Double.parseDouble(pointStr[1]));
        Point searchedNode = tool.searchNearestData(queryNode);

        String result = MessageFormat.format(
                "距离查询点({0}, {1})最近的坐标点为({2}, {3})", queryNode.x, queryNode.y,
                searchedNode.x, searchedNode.y);

//        //重新构造KD树,去除之前的访问记录
//        tool.createKDTree();
//        queryNode = new Point(2, 4.5);
//        searchedNode = tool.searchNearestData(queryNode);
//        System.out.println(MessageFormat.format(
//                "距离查询点({0}, {1})最近的坐标点为({2}, {3})", queryNode.x, queryNode.y,
//                searchedNode.x, searchedNode.y));
    }
}
