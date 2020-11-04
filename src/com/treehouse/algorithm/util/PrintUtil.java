package com.treehouse.algorithm.util;

/**
 * @ClassName: PrintUtil 
 * @Description: 打印工具类 
 * @author HongDa
 * @date 2020年10月29日 下午4:56:38
 */
public class PrintUtil {
	
	/**
	 * @Description 打印int数组
	 * @author HongDa
	 * @param arr 数组
	 * @throws
	 */
	public static void printArray(int[] arr){
		
		System.out.print("[");
		for(int i = 0; i < arr.length; i++){
			if(i == arr.length - 1){
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i] + ",");
			}
		}
		System.out.println("]");
	}
}
