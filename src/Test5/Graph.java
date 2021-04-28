package Test5;

import java.util.Stack;

/**
 * @version v1.0
 * @ClassName: Graph
 * @Description: 图类
 * @Author: ChenQ
 * @Date: 2021/4/25 on 21:05
 */
public class Graph {
    int vexs[];//顶点表
    int arcs[][];//邻接矩阵
    int vexnum;//顶点数
    int arcnum;//边数

    int inf = 999;//无穷大
    int dist[];
    int pre[];
    public Graph(int vexnum,int arcnum){
        this.arcnum = arcnum;
        this.vexnum = vexnum;
        vexs = new int[vexnum+1];
        arcs = new int[vexnum+1][vexnum+1];
        dist = new int[vexnum+1];
        pre = new int[vexnum+1];
        for (int i = 1;i<=vexnum;i++){
            vexs[i] = i;
            dist[i] = inf;
            pre[i] = -1;
        }
        dist[1] = 0;

    }
    public void insertEdge(int v1,int v2,int weight){
        arcs[v1][v2] = weight;
        arcs[v2][v1] = weight;
    }

    public void shortTestPath(int v0,int end){
        Node E = new Node(v0,0);
        MinHeap minHeap = new MinHeap(100);
        minHeap.insert(E);
        while (!minHeap.isEmpty()){
            E = minHeap.delete();
            if (dist[E.i]<E.length){
                continue;
            }
            for (int j = 1;j<=vexnum;j++){
                if ((arcs[E.i][j]<inf) && (arcs[E.i][j]+E.length)<dist[j]){
                    dist[j] = arcs[E.i][j]+E.length;
                    pre[j] = E.i;
                    Node node = new Node(j,dist[j]);
                    minHeap.insert(node);
                }
            }
        }

        for (int i=1;i<pre.length;i++){
            System.out.print(pre[i]+" ");
        }
        System.out.println();
        //输出最短路径
        Stack<Integer> stack = new Stack<>();
        int index = end;
        while (index!=v0){
            stack.push(vexs[index]);
            index = pre[index];
        }
        //将源点vs加入栈
        stack.push(vexs[index]);
        while (!stack.empty()){
            int vertex = stack.pop();
            System.out.println(vertex+"---->");
        }
    }


}
