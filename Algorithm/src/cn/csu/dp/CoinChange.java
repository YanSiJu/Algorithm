package cn.csu.dp;

import java.util.Arrays;

/**
 * @author yansiju
 * @Title:
 * @Package
 * @Description:
 * @date 2020/9/3 16:49
 */
public class CoinChange {

    public int coinNumber(int[] coins,int amount){
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            result = Math.min(result, 1 + coinNumber(coins, amount - coin));
        }
        return result == Integer.MAX_VALUE ? -1:result;
    }

    public int coinNumberWithMemo(int[] coins, int amount){
        int[] memo = new int[amount+1];
        Arrays.fill(memo, amount + 1);
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (memo[amount - coin] == 0){
                memo[amount - coin] = coinNumberWithMemo(coins,amount - coin);
            }
            result = Math.min(result,1 + memo[amount - coin]);
        }
        return result == Integer.MAX_VALUE ? -1:result;
    }

    public int coinNumberWithDpTable(int[] coins,int amount){
        int[] memo = new int[amount+1];
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        for (int i = 0; i < amount+1; i++) {
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(i - amount < 0){
                    continue;
                }
                memo[i] = Math.min(result,1 + memo[i - coin]);
            }
        }
        return memo[amount] == amount+1?-1:memo[amount];
    }
}
