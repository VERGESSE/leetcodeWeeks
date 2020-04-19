package two;

import java.util.*;

/*  5389
点菜展示表
给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
orders[i]=[customerNamei,tableNumberi,foodItemi] ，
其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，
而 foodItemi 是客户点的餐品名称。

请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号
 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌
 订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。

注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。

输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
解释：
点菜展示表如下所示：
Table,Beef Burrito,Ceviche,Fried Chicken,Water
3    ,0           ,2      ,1            ,0
5    ,0           ,1      ,0            ,1
10   ,1           ,0      ,0            ,0
对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
餐桌 10：Corina 点了 "Beef Burrito"
 */
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        Set<String> table = new TreeSet<>();
        Set<Integer> custome = new TreeSet<>();
        Map<Integer,Map<String,Integer>> map = new HashMap<>();
        for (List<String> order : orders) {
            String foodItem = order.get(2);
            table.add(foodItem);
            String s = order.get(1);
            custome.add(Integer.valueOf(s));
            Map<String, Integer> custMap = map.getOrDefault(Integer.valueOf(s), new TreeMap<>());
            Integer mapOrDefault = custMap.getOrDefault(foodItem, 0);
            custMap.put(foodItem,mapOrDefault+1);
            System.out.println(mapOrDefault+1);
            map.put(Integer.valueOf(s),custMap);
        }
        LinkedList<String> tableList = new LinkedList<>(table);
        tableList.addFirst("Table");
        res.add(tableList);
        for (Integer s : custome) {
            ArrayList<String> list = new ArrayList<>();
            list.add(String.valueOf(s));
            Map<String, Integer> foodItemNumMap = map.get(s);
            for (String foodItem : table) {
                Integer num = foodItemNumMap.getOrDefault(foodItem, 0);
                list.add(String.valueOf(num));
            }
            res.add(list);
        }
        return res;
    }
}








































