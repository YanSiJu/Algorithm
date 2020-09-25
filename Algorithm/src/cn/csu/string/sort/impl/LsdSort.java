package cn.csu.string.sort.impl;

import cn.csu.string.sort.Sort;
import sun.text.resources.FormatData;
import sun.util.resources.cldr.rn.LocaleNames_rn;

/**
 * @author yansiju
 * @Title:
 * @Package
 * @Description: 低位优先排序
 * @date 2020/9/211:01
 */
public class LsdSort implements Sort {

    @Override
    public void sort(String[] s, int r) {
        lsdSort(s,s.length,r);
    }

    public void lsdSort(String[] s,int w,int r){
        int len = s.length;
        for (int d = w-1; d >= 0; d--) {
            String[] aux = new String[len];
            int[] count = new int[r+2];
            for (int i = 0; i < len; i++) {
                count[charAt(s[i],d)+1]++;
            }
            for (int i = 0; i < r+1; i++) {
                count[i+1]+=count[i];
            }
            for (int i = 0; i < len; i++) {
                aux[count[charAt(s[i],d)]++] = s[i];
            }

            for (int i = 0; i < len; i++) {
                s[i] = aux[i];
            }
        }
    }

    public int charAt(String s,int d){
        if(d < 0 || d >= s.length()){
            return -1;
        } else{
            return s.charAt(d);
        }
    }
}
