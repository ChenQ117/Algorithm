package Test4;

import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: QueenTest
 * @Description: n后测试
 * @Author: ChenQ
 * @Date: 2021/4/23 on 22:21
 */
public class QueenTest {
    int n;//皇后个数
    int []x;//记录当前解
    int sum;//可行解的个数
    String [][] y;

    public QueenTest(int n) {
        this.n = n;
        x = new int[n+1];
        sum = 0;
        y = new String[n+1][n+1];
        for (int i=1;i<n+1;i++){
            for (int j=1;j<n+1;j++){
                y[i][j] = "○";
            }
        }
    }

    //限界条件
    public boolean place(int k){
        for (int j=1;j<k;j++){
            if (Math.abs(k-j) == Math.abs(x[k]-x[j])||x[j] == x[k]){
                return false;
            }
        }
        return true;
    }
    public void backTrack(int t){
        if (t>n){//遍历到叶结点
            sum++;
            System.out.println("第"+sum+"种可行解为");
            for (int i=1;i<n+1;i++){
                System.out.print(x[i]);
                y[i][x[i]] = "●";
            }
            System.out.println();
            for (int i=1;i<n+1;i++){
                for (int j=1;j<n+1;j++){
                    System.out.print(y[i][j]);
                    y[i][j] = "○";
                }
                System.out.println();
            }

        }else {
            for (int i=1;i<=n;i++){
                x[t] = i;
                if (place(t)){
                    backTrack(t+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入皇后个数");
        int n = sc.nextInt();
        QueenTest queenTest = new QueenTest(n);
        System.out.println("可行解为");
        queenTest.backTrack(1);
    }
}
