package com.alin.messageByme;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：raozl
 * @Date：2023/5/10 17:03
 */
@SpringBootTest(classes = ReadCVSTest.class)
public class ReadCVSTest {

    // 主要是用来测试读取大文件的CVS文件，根据某些条件捞出这一行数据
    @Test
    public void readFile() throws IOException {
        long start = System.currentTimeMillis();
        String filePath = "C:\\Users\\user\\Downloads\\201307-citibike-tripdata\\2013-07 - Citi Bike trip data.csv";
        File file = new File(filePath);
        LineIterator lineIterator = FileUtils.lineIterator(file, "UTF-8");
        List<String> dataList = new ArrayList<>();
        int i = 0;
        while (lineIterator.hasNext()) {
            String str = lineIterator.nextLine();
            if (str.contains("-73.96905301") && str.contains("E 11 St & Broadway") && str.contains("W 26 St & 8 Ave")) {
                dataList.add(str);
            }
            i++;
        }
        System.out.println(i);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start) + "ms");
    }

    @Test
    public void readFileByinputStream() throws IOException {
        String filePath = "C:\\Users\\user\\Downloads\\201307-citibike-tripdata\\2013-07 - Citi Bike trip data.csv";
        File file = new File(filePath);
        boolean file1 = file.isFile();
        FileInputStream fileInputStream = null;
        byte[] bytes = new byte[2048];
//        List<String> dataList = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(filePath);
            int data = fileInputStream.read(bytes);
            while (data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void stringBuilderDemo() {
        StringBuilder stringBuilder = new StringBuilder("select * from table where 1=1 and id in (");
        for (int i = 0; i < 10; i++) {
            stringBuilder.append("?,");
        }
        stringBuilder.append("1");
        System.out.println(stringBuilder.append(")").toString());
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("1"));
        System.out.println(stringBuilder.append(")").toString());
    }

    @Test
    public void testStrContainsDemo(){
        String str ="\"634\",\"2013-07-01 00:00:00\",\"2013-07-01 00:10:34\",\"164\",\"E 47 St & 2 Ave\",\"40.75323098\",\"-73.97032517\",\"504\",\"1 Ave & E 15 St\",\"40.73221853\",\"-73.98165557\",\"16950\",\"Customer\",\\N,\"0\"";
        if (str.contains("228")) {
            System.out.println(11111);
        }
    }
}
