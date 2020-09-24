package cn.csu.dp;

/**
 * @author yansiju
 * @Title:
 * @Package
 * @Description: 菲波拉契数列
 * @date 2020/9/3 15:10
 */
public class Fibonacci {

    public int fib(int n){
          //return n == 1 || n == 2 ?1:fib(n-1) + fib(n-2);
        if (n <= 0){
            return -1;
        }else if(n == 1 || n == 2){
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    public int fibWithMemo(int n){
        if(n <= 0){
            return -1;
        }
        int[] fib = new int[n+1];
        fib[1] = fib[2] = 1;
        return memo(fib,n);
    }

    private int memo(int[] fib,int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            if(fib[n-1] == 0){
                fib[n-1] = memo(fib,n-1);
            }
            if(fib[n-2] == 0){
                fib[n-2] = memo(fib,n-2);
            }
            if (fib[n] == 0) {
                fib[n] = fib[n-1] + fib[n-2];
            }
            return fib[n];
        }
    }

    public int fibWithDpTable(int n){
        if(n <= 0){
            return -1;
        }
        int[] fib = new int[n+1];
        fib[1] = fib[2] = 1;
        for (int i = 3; i < n+1; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
