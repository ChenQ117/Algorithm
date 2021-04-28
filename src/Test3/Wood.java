package Test3;

import java.util.Comparator;

/**
 * @version v1.0
 * @ClassName: Wood
 * @Description: 物品
 * @Author: ChenQ
 * @Date: 2021/4/16 on 18:08
 */
public class Wood implements Comparable<Wood> {
    private int weight;
    private int price;
    private int id;
    private float value;//单价

    public float getValue() {
        return value;
    }

    public Wood(int weight, int price, int id) {
        this.weight = weight;
        this.price = price;
        this.id = id;
        value = (float) price/weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "物品{" +
                " id=" + id +
                ", price=" + price +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }


    @Override
    public int compareTo(Wood wood) {
        return wood.value>value?1:-1;
    }
}
