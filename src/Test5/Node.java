package Test5;

/**
 * @version v1.0
 * @ClassName: E
 * @Description: 结点类
 * @Author: ChenQ
 * @Date: 2021/4/25 on 20:17
 */
public class Node {
    int i;//顶点编号
    int length;//记录根到扩展结点的路径长度
    public Node(int i, int length){
        this.i = i;
        this.length = length;
    }
}
