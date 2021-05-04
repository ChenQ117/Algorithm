package Test7;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: Solution
 * @Description: 两地调度问题
 * @Author: ChenQ
 * @Date: 2021/5/4 on 11:29
 */
public class Solution {
    public static int twoCity(int cost[][]){
        int total = 0;
        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-ints[1]-(t1[0]-t1[1]);//按额外消费从小到大的顺序排序
            }
        });
        int n = cost.length/2;
       for (int i=0;i<cost.length/2;i++){
           total += cost[i][0]+cost[i+n][1];
       }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入面试总人数：");
        int n = sc.nextInt();
        System.out.println("请分别输入去A地和B地的消费：");
        int cost[][] =new int[n][3];
        for (int i=0;i<n;i++){
            cost[i][0] = sc.nextInt();//去往A地的消费
            cost[i][1] = sc.nextInt();//去往B地的消费
            cost[i][2] = i+1;//第几号面试者
        }
        int total = Solution.twoCity(cost);
        System.out.println("最低消费为："+total);
        for (int i=0;i<cost.length;i++){
            if (i<n/2){
                System.out.println(cost[i][2]+"去往A地");
            }else {
                System.out.println(cost[i][2]+"去往B地");
            }
        }
    }
}
