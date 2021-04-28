package Test6;

import java.util.ArrayList;

/**
 * @version v1.0
 * @ClassName: MyGraph
 * @Description:
 * @Author: ChenQ
 * @Date: 2021/4/25 on 23:38
 */
public class MGraph {
    //顶点数
    int verxnum;
    //边数
    int arcnum;
    //邻接矩阵
    int arcs[][];
    int dist[];
    int pre[];
    ArrayList<String> vertexList;
    static int inf=Integer.MAX_VALUE;
    public MGraph(int verxnum,int arcnum){
        this.verxnum=verxnum;
        this.arcnum=arcnum;
        arcs=new int[verxnum][verxnum];
        dist=new int[verxnum];
        pre=new int[verxnum];
        vertexList = new ArrayList<>();


    }
    public void insertEdge(String v1,String v2,int weight){
        arcs[vertexList.indexOf(v1)][vertexList.indexOf(v2)]=weight;
        arcs[vertexList.indexOf(v2)][vertexList.indexOf(v1)]=weight;
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void init(){
        for (int v=0;v<verxnum;v++){
            if(v==0){
                dist[v]=0;
            }else {
                dist[v]=inf;
            }
            pre[v]=-1;
        }
    }
    //计算单源最短路径的办法
    public void  DijKstra(int v0){
        E e=new E();
        MinHeap minHeap=new MinHeap();
        e.i=v0;
        e.length=0;
        minHeap.insert(e);
        while (!minHeap.isEmpty()){
            e=minHeap.DeleteMin();
            if(dist[e.i]<e.length){
                continue;
            }
            //遍历一遍顶点看和谁有边<inf就是这个意思
            for (int j=1;j<verxnum;j++){
                if((arcs[e.i][j]<inf)&&(e.length+arcs[e.i][j]<dist[j])){
                    dist[j]=e.length+arcs[e.i][j];
                    pre[j]=e.i;
                    E e1=new E(j,dist[j]);
                    minHeap.insert(e1);
                }

            }
        }
    }

}
