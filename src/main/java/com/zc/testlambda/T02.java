package com.zc.testlambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class T02
{
    @Test
    public void test01()
    {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        //1.使用lambda表达式排序
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

        //2.使用匿名内部类来排序
        Collections.sort(names, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
    }

    @Test
    public void test02()
    {
        List<String> names = new ArrayList<String>();
        names.add("Tao");
        names.add("bao");
        //map()方法接收了一个lambda表达式(实际上就是一个java.util.function.Function的实例)
        //命令式编程vs声明式编程
        List<String> lowercaseNames = names.stream().map((String name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        //省略参数类型
        List<String> lowercaseNames2 = names.stream().map((name) -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        //若lambda参数只有一个,可省略小括号
        List<String> lowercaseNames3 = names.stream().map(name -> {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        //若lambda表达式只包含一条语句时,可省略大括号,return和语句结尾的分号
        List<String> lowercaseNames4 = names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
    }
}
