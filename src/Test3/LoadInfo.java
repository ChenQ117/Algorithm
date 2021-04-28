package Test3;

/**
 * @version v1.0
 * @ClassName: LoadInfo
 * @Description: 背包装载的物品的信息
 * @Author: ChenQ
 * @Date: 2021/4/16 on 18:15
 */
public class LoadInfo {
    private int id;//最后一个物品的下标id
    private int flag;//0表示没装满，1表示装满
    private float partWeight;//存储最后一个物品装了多少

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public float getPartWeight() {
        return partWeight;
    }

    public void setPartWeight(float partWeight) {
        this.partWeight = partWeight;
    }
}
