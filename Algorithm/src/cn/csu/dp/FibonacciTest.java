package cn.csu.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yansiju
 * @Title:
 * @Package
 * @Description:
 * @date 2020/9/315:45
 */
class FibonacciTest {

    @Test
    void fib() {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 5; i < 15; i++) {
            System.out.println(fibonacci.fib(i)+"  "+fibonacci.fibWithMemo(i)+"  "+fibonacci.fibWithDpTable(i));
            System.out.println();
        }
        System.out.println(fibonacci.fib(0));
        System.out.println(fibonacci.fibWithMemo(0));
        System.out.println(fibonacci.fibWithDpTable(0));
    }

    @Test
    void fibWithMemo() {
    }

    @Test
    void fibWithDpTable() {
    }
}