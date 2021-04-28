package Test2;

/**
 * @version v1.0
 * @ClassName: SumInfo
 * @Description: 最大和的相关信息
 * @Author: ChenQ
 * @Date: 2021/4/11 on 10:12
 */
public class SumNode {
    int sum;//最大和
    int besti;//起始下标
    int bestj;//终止下标
    public void printInfo(){
        System.out.println("最大和为："+ sum);
        System.out.println("起始下标为："+besti);
        System.out.println("终止下标为："+bestj);
    }
}
