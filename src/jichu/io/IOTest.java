package jichu.io;

import java.io.*;
import java.util.Map;

/**
 * Java IO 相关联系
 *
 * @Author: liangxiao
 * @Date: Created in 14:39 2018/9/3
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        //可组合使用
//        OutputStream out=new BufferedOutputStream(new ObjectOutputStream(new FileOutputStream("D:\\IdeaProjects\\Algorithm\\src\\jichu\\io/test.txt")));
//        OutputStream out = new FileOutputStream("D:\\IdeaProjects\\Algorithm\\src\\jichu\\io/test.txt");
//        String str = "Hello World!!!";
//        byte b[] = str.getBytes();
//        out.write(b);
//        System.out.println(b);


        //字节到字符的转换
        try {
            StringBuffer strBuf = new StringBuffer();
            char[] buf = new char[1024];
            FileReader f = new FileReader("D:\\IdeaProjects\\Algorithm\\src\\jichu\\io/test.txt");
            while (f.read(buf) > 0) {
                strBuf.append(buf);
            }
            System.out.println(strBuf.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //读取文件通用方法
    private static void readAlreadyNosPictureToMap(String dataIn, Map<String, String> map) {
        BufferedReader br = null;
        File file = new File(dataIn);
        if (!file.exists()) {
            return;
        }
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(dataIn));//数据读取流
            br = new BufferedReader(isr);//定义数据读取流
            String eachLine = "";//定义一个字符串用来暂存读取的一行数据
            while ((eachLine = br.readLine()) != null) {
                if (eachLine.equals("")) { //跳过空行
                    continue;
                }
                eachLine = eachLine.trim();
                String[] sub = eachLine.split("####");
                String pictureId = sub[0];
                System.out.println("pictureId:" + pictureId);
                String wordHead = sub[3];
                System.out.println("wordHead:" + wordHead);
                map.put(pictureId, wordHead);
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


}
