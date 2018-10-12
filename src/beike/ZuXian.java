package beike;

import java.util.*;

/**
 * 寻找祖先关系
 * @Author: liangxiao
 * @Date: Created in 20:21 2018/9/3
 */


public class ZuXian {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = in.nextInt();
            people[i][1] = in.nextInt();
        }
        int m = in.nextInt();
        int[][] ask = new int[m][2];
        for (int i = 0; i < m; i++) {
            ask[i][0] = in.nextInt();
            ask[i][1] = in.nextInt();
        }
        System.out.println(makeRelationMap(n, people));
        for (int i=0;i<m;i++){
            System.out.println(findRelation(makeRelationMap(n, people),ask[i][0],ask[i][1]));
        }


    }

    //将一个人的祖先存成list，放在key为这个人的map中
    private static Map<Integer, List<Integer>> makeRelationMap(int n, int[][] people) {
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> zuxianList = new ArrayList<>();
            int zuxian = people[i][1];
            zuxianList.add(zuxian);
            relationMap.put(people[i][0], zuxianList);
        }
        for (int i = 0; i < n; i++) {
            int child = people[i][0];
            int fuqin = people[i][1];
            if (fuqin == -1) {
                continue;
            }
            List<Integer> childList = relationMap.get(child);
            List<Integer> fuqinList = relationMap.get(fuqin);
            while (!fuqinList.contains(-1)){
                childList.add(fuqinList.get(0));
                fuqinList=relationMap.get(fuqinList.get(0));
            }
            childList.addAll(fuqinList);
        }
        return relationMap;
    }

    private static int findRelation(Map<Integer,List<Integer>> map,int a,int b){
        if (map.get(a).contains(b)){
            return 2;
        }
        if (map.get(b).contains(a)){
            return 1;
        }
        return 0;
    }

}

