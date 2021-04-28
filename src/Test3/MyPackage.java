package Test3;

/**
 * @version v1.0
 * @ClassName: GreedyPackage
 * @Description: 01背包问题
 * @Author: ChenQ
 * @Date: 2021/4/16 on 18:02
 */
public class MyPackage {
    private int capacity;//背包容量
    private LoadInfo loadInfo;//装载的物品信息

    public MyPackage(int capacity) {
        this.capacity = capacity;
        loadInfo = new LoadInfo();
    }

    public LoadInfo greedyLoad(Wood[] woods){
        int sum = 0;
        int i=0;
        for (;i<woods.length;i++){
            sum += woods[i].getWeight();
            if (sum>=capacity){
                break;
            }
        }
        if (i == woods.length){
            loadInfo.setId(i-1);
            if (sum == capacity){
                loadInfo.setFlag(1);
                loadInfo.setPartWeight(woods[i-1].getWeight());
            }else {
                loadInfo.setFlag(0);
                loadInfo.setPartWeight(capacity-sum);
            }
        }else {
            loadInfo.setId(i);
            loadInfo.setPartWeight(woods[i].getWeight()-(sum-capacity));
            loadInfo.setFlag(1);
        }
        return loadInfo;
    }
}
