package cn.edu.bit.lemondy.leetcode.medium;

import java.util.*;
import java.util.Scanner;

/**
 * 
 * @author zhangyun09
 * @description 1. 货币之间的优先级 GBP>USD>CNY>HKD
 * 				2. 货币之间存在兑换汇率
 * 				3. 输入输出格式固定：input：3 8 2 1250 CNY MAX； output：3 GBP 1 USD 7 CNY 1 HKD
 */
public class CurrencyExchange {
	public static final int GBP = 0;
	public static final int USD = 1;
	public static final int CNY = 2;
	public static final int HKD = 3;
	
    private static List<String> keyWordList = new LinkedList<String>();
    private static List<String> moneyTypeList = new LinkedList<String>();
    private static double[][] transformTable = new double[4][4];
    private static Map<String, Integer> moneyStr2Int = new HashMap<>();
    private static Map<Integer, String> moneyInt2Str = new HashMap<>();
    
    private static int GBP2USD = 0;
    private static int USD2CNY = 0;
    private static int CNY2HKD = 0;
    
    static {
        keyWordList.add("MAX");
        keyWordList.add("MIN");
        
        moneyTypeList.add("GBP");
        moneyTypeList.add("USD");
        moneyTypeList.add("CNY");
        moneyTypeList.add("HKD");
        
        moneyStr2Int.put("GBP", GBP);
        moneyStr2Int.put("USD", USD);
        moneyStr2Int.put("CNY", CNY);
        moneyStr2Int.put("HKD", HKD);
        
        moneyInt2Str.put(GBP, "GBP");
        moneyInt2Str.put(USD, "USD");
        moneyInt2Str.put(CNY, "CNY");
        moneyInt2Str.put(HKD, "HKD");
    }
    
    public static void generateTransformTable(int GBP2USD, int USD2CNY, int CNY2HKD) {
    	// gbp
    	transformTable[GBP][USD] = GBP2USD;
    	transformTable[GBP][CNY] = GBP2USD * USD2CNY;
    	transformTable[GBP][HKD] = GBP2USD * USD2CNY * CNY2HKD;
    	
    	// usd
    	transformTable[USD][GBP] = 1.0 / GBP2USD;
    	transformTable[USD][CNY] = USD2CNY;
    	transformTable[USD][HKD] = USD2CNY * CNY2HKD;
    	
    	// CNY
    	transformTable[CNY][GBP] = 1.0 / (GBP2USD * USD2CNY);
    	transformTable[CNY][USD] = 1.0 / USD2CNY;
    	transformTable[CNY][HKD] = CNY2HKD;
    	
    	// HKD
    	transformTable[HKD][GBP] = 1.0 / (GBP2USD * USD2CNY * CNY2HKD);
    	transformTable[HKD][USD] = 1.0 / (USD2CNY * CNY2HKD);
    	transformTable[HKD][CNY] = 1.0 / CNY2HKD;
    	
    }
    
    public static String maxTransform(String moneyType, long moneyAmounts) {
    	// 2 8 2 127 HKD MAX
    	// 3 8 2 1250 CNY MAX
    	// 1 6 1 127 HKD max
    	// 2 8 2 20 CNY MIN
    	// 3 GBP 1 USD 7 CNY 1 HKD
    	// ERROR
    	String result = "";
    	int index = moneyStr2Int.get(moneyType);
    	long spareMoney = moneyAmounts;
    	for (int i = GBP; i < index && spareMoney > 0; i++) {
    		result += " " + spareMoney / (int)transformTable[i][index] + " " + moneyInt2Str.get(i);
    		spareMoney = spareMoney - (spareMoney / (int)transformTable[i][index]) * (int)transformTable[i][index];
    	}
    	if (spareMoney != 0) {
    		result += " " + spareMoney + " " + moneyType;
    	}
    	
        return result.trim();
    }
    
    public static String minTransform(String moneyType, long moneyAmounts) {
    	String result = "";
    	int index = moneyStr2Int.get(moneyType);
    	result += moneyAmounts * (int)transformTable[index][HKD] + " HKD"; 
    	return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long moneyAmounts = 0;
        //in.has
        while (in.hasNextLine()) {
            String inputStr = in.nextLine();
            try {
	            String[] items = inputStr.split(" ");
	            // 输入长度不对
	            if (items.length != 6) {
	                System.out.println("ERROR");
	                continue;
	            }
	            
	            // 输入货币名称或者兑换关键字不对
	            if (!moneyTypeList.contains(items[4]) ||
	                   !keyWordList.contains(items[5])) {
	                System.out.println("ERROR");
	                continue;
	            }

                CNY2HKD = Integer.parseInt(items[0]);
                USD2CNY = Integer.parseInt(items[1]);
                GBP2USD = Integer.parseInt(items[2]);
                moneyAmounts = Long.parseLong(items[3]);
                if (CNY2HKD <= 0 || USD2CNY <= 0 || GBP2USD <= 0 || moneyAmounts <= 0) {
                    System.out.println("ERROR");
                    continue;
                }
                
                generateTransformTable(GBP2USD, USD2CNY, CNY2HKD);
                
                if ("MAX".equals(items[5])){
                    System.out.println(maxTransform(items[4], moneyAmounts));
                } else {
                    System.out.println(minTransform(items[4], moneyAmounts));
                }
            } catch(Exception e) {
                System.out.println("ERROR");
                continue;
            }
           
        }
    }
}