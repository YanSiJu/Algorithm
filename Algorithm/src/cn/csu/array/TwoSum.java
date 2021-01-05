package cn.csu.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @package:cn.csu.array
 * @ClassName: TwoSum
 * @Description: 两数之和
 * @Author: ZanderYan
 * @Date: 2021-01-03 15:40
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null){
                map.put(target-nums[i],i);
            }else {
                array[0] = index;
                array[1] = i;
                return array;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4,6},6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,2,4,4},6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3},6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{},6)));
    }
}
