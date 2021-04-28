package Test6;

/**
 * @version v1.0
 * @ClassName: MinHeap
 * @Description:
 * @Author: ChenQ
 * @Date: 2021/4/25 on 23:39
 */
public class MinHeap {
    E heap[];
    int size;
    static int Maxsize=100;
    public MinHeap(){
        size=0;
        //用负数来做哨兵
        E e=new E(-1,-1);
        heap=new E[Maxsize];
        heap[0]=e;
    }
    //heap[0]是哨兵元素 是最小值
    public void insert(E e){
        int i;
        //还要判断堆是否满了
        if(isFull()){
            System.out.println("堆已满");
            return;
        }
        i=++size;
        //向下过滤节点 父节点换下来
        for(;heap[i/2].length>e.length;i/=2){
            heap[i]=heap[i/2];
        }
        //将item插入
        heap[i]=e;
    }
    public E DeleteMin(){
        int parent,child;
        E MinItem,temp;

        if(isEmpty()){
            System.out.println("最小堆已为空");
        }
        //判断一下堆是否为空,将最小值拿出来
        MinItem=heap[1];
        //最后一个元素替换上来
        temp=heap[size--];
        for(parent=1;parent*2<=size;parent=child){
            child=parent*2;
            //如果右儿子比左儿子要小那么去右边找
            if(child!=size&&heap[child].length>heap[child+1].length){
                child++;
            }
            //把child指向左右儿子较小者,这个break感觉跳不出去
            if(temp.length<=heap[child].length)
                break;
            else
                heap[parent]=heap[child];

        }
        //循环结束的时候代表我要放的位置找到了
        heap[parent]=temp;
        return MinItem;

    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else {
            return  false;
        }
    }
    public boolean isFull(){
        if(size==Maxsize){
            return true;
        }else {
            return false;
        }
    }
}
