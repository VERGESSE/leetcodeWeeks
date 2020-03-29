package three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 *
 * 1. checkIn(int id, string stationName, int t)
 *
 * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
 * 一个乘客在同一时间只能在一个地铁站进入或者离开。
 * 2. checkOut(int id, string stationName, int t)
 *
 * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
 * 3. getAverageTime(string startStation, string endStation)
 *
 * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
 * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
 * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
 * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。
 * 也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 *
 *
 * 输入：
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 *
 * 输出：
 * [null,null,null,null,null,null,null,14.0,11.0,null,11.0,null,12.0]
 *
 * 解释：
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);
 * undergroundSystem.checkOut(27, "Waterloo", 20);
 * undergroundSystem.checkOut(32, "Cambridge", 22);
 * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
 * undergroundSystem.checkOut(10, "Waterloo", 38);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
 */
class UndergroundSystem {

    private HashMap<String, List<Node>> checkInMap = new HashMap<>();
    private HashMap<String, List<Node>> checkOutMap = new HashMap<>();

    public UndergroundSystem() {

    }
    
    public void checkIn(int id, String stationName, int t) {
        List<Node> nodes = checkInMap.getOrDefault(stationName, new ArrayList<>());
        nodes.add(new Node(id,t));
        checkInMap.put(stationName, nodes);
    }
    
    public void checkOut(int id, String stationName, int t) {
        List<Node> nodes = checkOutMap.getOrDefault(stationName, new ArrayList<>());
        nodes.add(new Node(id,t));
        checkOutMap.put(stationName, nodes);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Node> checkInList = checkInMap.get(startStation);
        List<Node> checkOutList = checkOutMap.get(endStation);

        int num = 0;
        double time = 0;
        for (Node node : checkOutList) {
            int i = checkInList.indexOf(node);
            if (i == -1) continue;
            num ++;
            Node node1 = checkInList.get(i);
            time += node.time - node1.time;
        }
        return time/num;
    }

    class Node{
        int id;
        int time;

        public Node(int id,int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */