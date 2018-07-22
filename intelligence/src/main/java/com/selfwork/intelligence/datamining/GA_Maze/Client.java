package com.selfwork.intelligence.datamining.GA_Maze;

/**
 * 遗传算法在走迷宫游戏的应用
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] args) {
//		//迷宫地图文件数据地址
//		String filePath = "C:\\Users\\lyq\\Desktop\\icon\\mapData.txt";
//		//初始个体数量
//		int initSetsNum = 4;

        String inputStr = "0 0 0 0 0;2 0 0 -1 0;0 0 0 0 0;0 -1 0 0 -1;0 0 0 0 1";
        GATool tool = new GATool(inputStr);
        String result = tool.goOutMaze();
        System.out.println(result);
    }

}

