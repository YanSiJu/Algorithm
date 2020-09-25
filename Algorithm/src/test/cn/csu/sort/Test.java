package test.cn.csu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: （非）静态代码块执行顺序测试
 * @Author: Mr.Wang
 * @Date: $
 */
public class Test {
    public Test() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.println("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.println("静态代码块！--");
    }

    public static void test() {
        System.out.print("静态方法中的内容 !--");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }

    main
    public static void main(String[] args) {
        System.out.println(java);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }
        //Test test = new Test();
        //Test.test();
        //List myList = Arrays.asList(1, 2, 3);
        //System.out.println(myList.getClass());
        //运行时报错：UnsupportedOperationException
        //myList.add(4);
        //运行时报错：UnsupportedOperationException
        //myList.remove(1);
        //运行时报错：UnsupportedOperationException
        //myList.clear();
    }
}
