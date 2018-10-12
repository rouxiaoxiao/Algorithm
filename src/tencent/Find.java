package tencent;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {

    }

    private static int find(int[] array, int count) {
        if (array == null || count == 0) {
            return -1;
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < array.length - 1; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (array[i] < array[i + 1]) {
                list.add(array[i]);
            }
            results.add(list);
        }
        int lengthIndex = -1;
        int length = 0;
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).size() > length) {
                length = results.get(i).size();
                lengthIndex = i;
            }
        }
        int resultIndex = 0;
        for (int i = 0; i <= lengthIndex; i++) {
            resultIndex = resultIndex + results.get(i).size();
        }
        return resultIndex;
    }
}
