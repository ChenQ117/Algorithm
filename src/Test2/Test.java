package Test2;

import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: Test
 * @Description: 测试类
 * @Author: ChenQ
 * @Date: 2021/4/11 on 10:29
 */
public class Test {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("============实验1=============");
        test1();
        System.out.println("============实验2=============");
        test2();
    }
    public static void test1(){
        int[] a = new int[100];
        System.out.println("请输入数组,并以-100结束");
        a[0] = 0;
        int i = 1;//数组下标从1开始
        while (scanner.hasNextInt()){
            a[i] = scanner.nextInt();
            if (a[i] == -100) break;
            i++;
        }
        System.out.println("请输入所求子段的起始位置和终止位置");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        SumNode sumNode = SubMaxSum.getSumNodeInfo(a,start,end);
        sumNode.printInfo();
    }
    public static void test2(){
        System.out.println("请输入字符串X");
        char[] x ;
        char[] y ;

        String next = scanner.next();
        next = " "+next;
        x = next.toCharArray();

        System.out.println("请输入字符串Y");
        next = scanner.next();
        next = " "+next;
        y = next.toCharArray();
        LCS.getLength(x,y);
        LCS.getLcs(x.length-1,y.length-1,x);
    }
}
