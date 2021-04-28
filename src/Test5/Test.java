package Test5;

import java.util.Scanner;
import java.util.Stack;

/**
 * @version v1.0
 * @ClassName: Test
 * @Description: 测试类
 * @Author: ChenQ
 * @Date: 2021/4/25 on 22:56
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点数和边数：");
        int vexnum = sc.nextInt();
        int arcnum = sc.nextInt();
        Graph graph = new Graph(vexnum,arcnum);
        System.out.println("请输入边的信息");
        for (int i = 0;i<arcnum;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            graph.insertEdge(v1,v2,weight);
        }
        System.out.println("请输入源点V0和终点end");
        int v0 = sc.nextInt();
        int end = sc.nextInt();
        graph.shortTestPath(v0,end);

    }
}
