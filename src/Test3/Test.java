package Test3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: Test
 * @Description: 测试类
 * @Author: ChenQ
 * @Date: 2021/4/16 on 18:34
 */
public class Test {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("============实验1=============");
        Test1();
        System.out.println("============实验2=============");
        Test2();
    }
    public static void Test1(){
        System.out.println("请输入物品个数");
        int n = sc.nextInt();
        System.out.println("请输入物品重量和价值");
        Wood[] woods = new Wood[n];
        for (int i=0;i<woods.length;i++){
            //int id = sc.nextInt();

            int weight = sc.nextInt();
            int price = sc.nextInt();
            woods[i] = new Wood(weight,price,i+1);
        }
        Arrays.sort(woods);
        System.out.println("请输入背包的容量");
        MyPackage myPackage = new MyPackage(sc.nextInt());
        LoadInfo loadInfo = myPackage.greedyLoad(woods);
        int pk_price = 0;//背包的总价值
        if (loadInfo.getFlag() == 0){
            for (Wood wood:woods){
                pk_price += wood.getPrice();
            }
            System.out.println("所有物品均装入背包,背包还能装入"+loadInfo.getPartWeight());
        }else {
            System.out.println("背包已装满,装入背包的物品为：");
            int id = loadInfo.getId();
            for (int i=0;i<id;i++){
                pk_price += woods[i].getPrice();
                System.out.println(woods[i]);
            }
            System.out.println("物品{" +
                    " id=" + woods[id].getId() +
                    ", price=" + woods[id].getPrice() +
                    ", weight=" + woods[id].getWeight() +
                    ", loadweight=" + loadInfo.getPartWeight()+
                    ", value=" + woods[id].getValue() +
                    ", 比例=" + (loadInfo.getPartWeight()/woods[id].getWeight()) +
                    '}'
            );
            pk_price += ((float)woods[id].getPrice()/woods[id].getWeight())*loadInfo.getPartWeight();
        }
        System.out.println("背包中装入的总价值为："+pk_price);
    }
    public static void Test2(){
        System.out.println("请输入活动个数");
        int n = sc.nextInt();
        System.out.println("请输入活动的编号，开始时间和截止时间");
        MyActivity[] myActivities = new MyActivity[n];
        for (int i=0;i<myActivities.length;i++){
            int id = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            myActivities[i] = new MyActivity(id,start,end);
        }
        Arrays.sort(myActivities);
        for (MyActivity myActivity:myActivities){
            System.out.println(myActivity);
        }
        List<MyActivity> arrange = ActivityArrange.getArrange(myActivities);
        System.out.println("被选中的活动有：");
        System.out.println(arrange);
    }
}
