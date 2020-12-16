package com.zzk.snake.core;

import com.zzk.snake.constant.Constant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @BeforeEach
    void setUp() {

    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void outScore() {
        String str = null;
        ArrayList<String> readList = new ArrayList<String>();
        try {
            File file = new File(Constant.RANK_PRE);

            Reader fin = new FileReader(file);

            BufferedReader bufferRead = new BufferedReader(fin);
            while ((str = bufferRead.readLine()) != null && !"".equals(str)) {
                readList.add(str);
            }
//            输入分数数据（不会存储到实际的rank.txt文件中）但能够排序
//            readList.add("str");
//            readList.add("str");
//            readList.add("str");
//            readList.add("str");
            Collections.sort(readList, new Comparator<String>() {
                @Override
                public int compare(String lhs, String rhs) {
                    int a, b;
                    a = Integer.parseInt(lhs);
                    b = Integer.parseInt(rhs);
                    if (b > a) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            System.out.println(readList.get(0));
            System.out.println(readList.get(1));
            System.out.println(readList.get(2));
            bufferRead.close();
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}