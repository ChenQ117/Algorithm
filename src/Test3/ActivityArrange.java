package Test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: ActivityArrange
 * @Description: 活动安排类
 * @Author: ChenQ
 * @Date: 2021/4/16 on 19:27
 */
public class ActivityArrange {
    public static List<MyActivity> getArrange(MyActivity [] myActivities){
        List<MyActivity> list = new ArrayList<>();
        list.add(myActivities[0]);
        int time = myActivities[0].getEnd();
        for (int i=1;i<myActivities.length;i++){
            if (myActivities[i].getStart()>=time){
                time = myActivities[i].getEnd();
                list.add(myActivities[i]);
            }
        }
        return list;
    }

}
