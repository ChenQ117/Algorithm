package Test2;

/**
 * @version v1.0
 * @ClassName: SubMaxSum
 * @Description: 求解最大子段和算法
 * @Author: ChenQ
 * @Date: 2021/4/11 on 10:15
 */
public class SubMaxSum {
    static SumNode sumNode = new SumNode();
    public static SumNode getSumNodeInfo(int[] a, int start, int end){
        sumNode.besti = start-1;
        sumNode.bestj = sumNode.besti;
        sumNode.sum = 0;
        int[] b = new int[end - (start-1) +1];
        b[start-1] = 0;
        int i = 0;
        for (int j=start;j<=end;j++){
            if (b[j-1]>0){
                b[j] = b[j-1]+a[j];
            }else {
                b[j] = a[j];
                i = j;
            }
            if (sumNode.sum<b[j]){
                sumNode.sum = b[j];
                sumNode.besti = i;
                sumNode.bestj = j;
            }
        }
        return sumNode;
    }
}
