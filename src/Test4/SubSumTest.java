package Test4;

import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: SubSum
 * @Description: 子集和问题
 * @Author: ChenQ
 * @Date: 2021/4/23 on 23:17
 */
public class SubSumTest {
    int M;//和
    int []S ;//源集,下标从1开始
    int []choose;
    int sum;//可行子集的个数
    int currentSum;//当前子集的和

    public SubSumTest(int m, int[] s) {
        M = m;
        S = s;
        choose = new int[s.length];
        sum = 0;
        currentSum = 0;
    }

    public boolean addSum(int k){
        if (k>M){
            return false;
        }
        return true;
    }
    public void backTrack(int t){
        if (t>=S.length){
            if (currentSum == M){
                sum++;
                System.out.println("第"+sum+"个可行子集为");
                for (int i = 1;i<choose.length;i++){
                    if (choose[i] == 1){
                        System.out.print(S[i]+" ");
                    }
                }
                System.out.println();
            }
        }else {
            for (int i=0;i<=1;i++){
                choose[t] = i;
                if (i == 1){
                    currentSum+=S[t];
                }
                if (addSum(currentSum)){
                    backTrack(t+1);
                }
                if (choose[t] == 1){
                    currentSum-=S[t];
                    choose[t] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入和M");
        int M = sc.nextInt();
        System.out.println("请输入源集S的个数");
        int n = sc.nextInt();
        int[] S = new int[n+1];
        System.out.println("请输入源集S");
        for (int i=1;i<n+1;i++){
            S[i] = sc.nextInt();
        }
        SubSumTest subSumTest = new SubSumTest(M,S);
        subSumTest.backTrack(1);
    }
}
