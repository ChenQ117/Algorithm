package Test2;

/**
 * @version v1.0
 * @ClassName: LCS
 * @Description: 最长公共子序列算法
 * @Author: ChenQ
 * @Date: 2021/4/11 on 11:09
 */
public class LCS {
    static char b[][];
    static int c[][];
    public static void getLength(char []x,char []y){
        c = new int[x.length][y.length];
        b = new char[x.length][y.length];
        for (int i=0;i<x.length;i++) c[i][0] = 0;
        for (int j=0;j<y.length;j++) c[0][j] = 0;
        for (int i=1;i<x.length;i++){
            for (int j=1;j<y.length;j++){
                if (x[i] == y[j]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = '↖';
                }else if (c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '↑';
                }else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '←';
                }
            }
        }
        show(x,y,c);
    }
    public static void getLcs(int i,int j,char[] x){
        if (i==0||j==0) return;
        if (b[i][j] == '↖'){
            getLcs(i-1,j-1,x);
            System.out.print(x[i]);
        }else if (b[i][j] == '←'){
            getLcs(i,j-1,x);
        }else {
            getLcs(i-1,j,x);
        }
    }

    public static void show(char []x,char []y,int c[][]){
        System.out.print("  ");
        for (int j=0;j<y.length;j++) System.out.print(y[j]+" ");
        System.out.println();
        System.out.print("  ");
        for (int j=0;j<y.length;j++){
            System.out.print(b[0][j]+" ");
        }
        System.out.println();
        for (int i=0;i<x.length;i++){
            System.out.print(x[i]+" ");
            for (int j = 0;j<y.length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
            System.out.print("  ");
            if (i+1!=x.length){
                for (int j=0;j<y.length;j++){
                    System.out.print(b[i+1][j]+" ");
                }
                System.out.println();
            }
        }
    }

}
