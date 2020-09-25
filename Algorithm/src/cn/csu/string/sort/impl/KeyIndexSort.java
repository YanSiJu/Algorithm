package cn.csu.string.sort.impl;

import cn.csu.string.sort.Sort;
import cn.csu.string.sort.Student;

/**
 * @author yansiju
 * @Title:
 * @Package
 * @Description: 键索引排序
 * @date 2020/9/210:23
 */
public class KeyIndexSort{

    public void sort(Student[] a, int r) {
        int len = a.length;
        int[] count = new int[r+1];
        Student[] aux = new Student[len];

        //统计出现频率
        for (int i = 0; i < len; i++) {
            count[a[i].getIndex()+1]++;
        }

        //把频率转换为索引
        for (int i = 0; i < r; i++) {
            count[i+1]+=count[i];
        }

        for (int i = 0; i < len; i++) {
            aux[count[a[i].getIndex()]++] = a[i];
        }

        //数据回写
        for (int i = 0; i < len; i++) {
            a[i] = aux[i];
        }

    }


}
