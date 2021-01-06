package cn.csu.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @package:cn.csu.sort
 * @ClassName: Intersection
 * @Description: 两个数组的交集
 * @Author: ZanderYan
 * @Date: 2021-01-05 21:15
 */
public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length + nums2.length);
        for (int i = 1; i < nums1.length; i++) {
            int temp = nums1[i];
            int j;
            for (j = i - 1; j >= 0 && nums1[j] > nums1[i]; j--) {
            }
            for (int k = i - 1; k > j; k--) {
                nums1[k + 1] = nums1[k];
            }
            nums1[j + 1] = temp;
        }
        //System.out.println(Arrays.toString(nums1));
        for (int i = 0; i < nums2.length; i++) {
            if (!set.contains(nums2[i])) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] == nums1[j]) {
                        set.add(nums2[i]);
                        break;
                    }
                }
            }
        }
        int[] result = new int[set.size()];
        Integer[] array = set.toArray(new Integer[]{});
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {8, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        insertionSort(nums1);
        insertionSort(nums2);
        int[] result;
        Set<Integer> set = new HashSet<>(nums1.length + nums2.length);
        for (int j = 0, i = 0; j < nums2.length && i < nums1.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < result.length && iterator.hasNext(); i++) {
            result[i] = iterator.next();
        }
        return result;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > array[i]; j--) {
            }
            for (int k = i - 1; k > j; k--) {
                array[k + 1] = array[k];
            }
            array[j + 1] = temp;
        }
    }

}