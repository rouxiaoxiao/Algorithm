package utils.txt;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SelectName {
    private static String dataIn = "C:\\Users\\xiaoxiao\\Desktop/otherData.json";
    private static String dataOut = "C:\\Users\\xiaoxiao\\Desktop/otherDataOut.json";
    private static Set<String> set = new HashSet<String>();

    public static void main(String[] args) {
        setNameToSet(dataIn, set);
        Iterator<String> iteratorSet = set.iterator();
        System.out.println(set.size());
        while (iteratorSet.hasNext()) {
            String next = iteratorSet.next();
            writeFileFromStr(dataOut,next);
            System.out.println(next);
        }
    }

    private static void setNameToSet(String dataIn, Set<String> set) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(dataIn));//数据读取流
            br = new BufferedReader(isr);//定义数据读取流
            String eachLine = "";//定义一个字符串用来暂存读取的一行数据
            while ((eachLine = br.readLine()) != null) {
                if (eachLine.equals("")) { //跳过空行
                    continue;
                }
                eachLine = eachLine.trim();
                char head = eachLine.charAt(0);
                if (head >= 'A' && head <= 'Z') {
                    set.add(eachLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private static void writeFileFromStr(String urlOut, String data) {
        OutputStreamWriter osw = null;//申明一个OutputStreamWriter，用来输出数据
        try {
            //osw = new OutputStreamWriter(new FileOutputStream(urlOut), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream(urlOut, true));
            osw.write(data.trim());
            osw.write("\r\n");
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
