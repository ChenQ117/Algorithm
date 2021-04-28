package Test3;

/**
 * @version v1.0
 * @ClassName: MyActivity
 * @Description: 活动信息
 * @Author: ChenQ
 * @Date: 2021/4/16 on 19:21
 */
public class MyActivity implements Comparable<MyActivity>{
    private int id;//活动编号
    private int start;//活动开始时间
    private int end;//活动结束时间

    public MyActivity(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "活动{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override//按照活动结束时间递递增顺序排序
    public int compareTo(MyActivity myActivity) {
        return end-myActivity.end;
    }
}
