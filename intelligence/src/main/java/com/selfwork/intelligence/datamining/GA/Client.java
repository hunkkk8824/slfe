package com.selfwork.intelligence.datamining.GA;

/**
 * Genetic遗传算法测试类
 *
 * @author lyq
 */
public class Client {
    public static void main(String[] args) {
        //变量最小值和最大值
//		int minNum = 1;
//		int maxNum = 7;
//		//初始群体规模
//		int initSetsNum = 4;
        String input="1 7 4";
        GATool tool = new GATool(input);
        String result = tool.geneticCal();
    }
}
