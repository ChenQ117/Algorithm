package Test5;

/**
 * @version v1.0
 * @ClassName: MinHeap
 * @Description: 小根堆
 * @Author: ChenQ
 * @Date: 2021/4/25 on 19:37
 */
public class MinHeap {
    Node[] heap;//存储堆元素的数组
    int size;//堆中当前元素个数
    int capacity;//堆的最大容量
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.heap = new Node[capacity];
        size = 0;
        Node e = new Node(0,-1);//哨兵
        heap[0] = e;
    }
    //插入
    public void insert(Node E){
        if (isFull()){
            System.out.println("堆已满");
            return;
        }
        int i;
        i = ++size;//i指向插入后堆中的最后一个元素位置

        //假设当前结点插在最后一个结点上，如果父节点比子结点还小，则父节点下移
        //不用判断i是否等于0，因为一定会找到一个比当前要插入结点小的结点，这就是哨兵的作用
        for (;heap[i/2].length>E.length;i++){
            heap[i] = heap[i/2];
        }
        heap[i] = E;
    }

    public Node delete(){
        if (isEmpty()){
            return null;
        }
        Node node = heap[1];//删除最小的结点，也就是最顶上的结点
        Node temp = heap[size--];//获取最大元素，即最后一个元素，放到根部
        int parent = 1;
        int child = 1;
        for (;parent*2<=size;parent = child){
            child = parent*2;
            //如果右儿子存在，找出左右儿子中较小的那个
            if (child!=size && heap[child].length>heap[child+1].length){
                child = child+1;
            }
            //假设temp为父节点，如果父节点比子结点还大,则将父节点换成小的那个
            if (temp.length<=heap[child].length){
                break;
            }else {
                heap[parent] = heap[child];
            }
        }
        heap[parent] = temp;
        return node;
    }

    public boolean isEmpty(){
        return size<=0;
    }
    public boolean isFull(){
        return size>=capacity;
    }

}
