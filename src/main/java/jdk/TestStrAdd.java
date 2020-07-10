package jdk;

import java.time.LocalTime;

//测试字符串拼接耗时
//1000个  纯字符串指数级增加  stringbuilder几乎不耗时
public class TestStrAdd {

    public static void main(String[] args) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        long l = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            str += " abcd";
        }
        System.out.println(System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            sb.append(" abcd");
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
