package Test6;

import java.util.Scanner;
import java.util.Stack;

/**
 * @version v1.0
 * @ClassName: Main
 * @Description:
 * @Author: ChenQ
 * @Date: 2021/4/25 on 23:38
 */
public class Main {
    public static void main(String[] args) {
        init();

    }
    public static  void init(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入点的数量");
        int verxnum=input.nextInt();
        System.out.println("请输入边的数量");
        int arcnum=input.nextInt();
        MGraph graph=new MGraph(verxnum,arcnum);
        String c1=input.nextLine();
        for(int i=0;i<verxnum;i++){
            System.out.println("请输入第"+(i+1)+"个点");
            String c=input.nextLine();
            graph.insertVertex(c);
        }

        System.out.println("请输入边和权重");
        for(int i=0;i<arcnum;i++){
            String v[]=input.nextLine().split(" ");
//            int weight=input.nextInt();
            graph.insertEdge(v[0],v[1],Integer.parseInt(v[2]));
        }
        graph.init();
        graph.DijKstra(0);
        for(int v=0;v<graph.verxnum;v++){
            System.out.print(graph.dist[v]+" ");
        }
        System.out.println();
        for(int v=0;v<graph.verxnum;v++){
            System.out.print(graph.pre[v]+" ");
        }
        System.out.println();
        Stack<Integer> s=new Stack();
        int v;
        int sum=0;
        for(int i=0;i<verxnum;i++){
            v=i;
            s.push(v);
            if(graph.pre[v]==-1){
                s.push(v);
            }
            while(graph.pre[v]!=-1){
                s.push(graph.pre[v]);
                v=graph.pre[v];
            }
            while (!s.isEmpty()){
                System.out.print(graph.vertexList.get(s.pop()));

                if(!s.isEmpty()){
                     System.out.print("->");
                }
            }
            System.out.println(" "+graph.dist[i]);
        }
    }
}
