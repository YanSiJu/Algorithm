package cn.csu.sort;

/**
 * @package:cn.csu.sort
 * @ClassName: MaxPq
 * @Description: 基于最大堆的完全二叉树
 * @Author: ZanderYan
 * @Date: 2020-12-13 16:04
 */
public class MaxPq<key extends Comparable> {

    private key[] pq;
    private int size;
    private static final int DEFAULT_SIZE = 10;


    /**
     * @Author: ZanderYan
     * @Description:
     * @Param: []
     * @return:
     * @Date:
     */
    public MaxPq() {
        pq = (key[]) new Comparable[DEFAULT_SIZE + 1];
    }

    /**
     * @Author: ZanderYan
     * @Description: 创建一个大小为n的完全二叉树
     * @Param: [n]
     * @return:
     * @Date:
     */
    public MaxPq(int n) {
        pq = (key[]) new Comparable[n + 1];
    }

    /**
     * @Author: ZanderYan
     * @Description: 添加元素
     * @Param: [k]
     * return: void
     * @Date: 12/13/2020
     */
    public void add(key k) {
        pq[++size] = k;
        swim(size);
    }


    /**
     * @Author: ZanderYan
     * @Description: 删除最大元素并返回
     * @Param: []
     * return: key
     * @Date: 12/13/2020
     */
    public key deleteMax() {
        key max = pq[1];
        exch(1, size--);
        pq[size + 1] = null;
        sink(1);
        return max;
    }


    /**
     * @Author: ZanderYan
     * @Description: 将位置k处的元素上浮，以恢复堆的结构
     * @Param: [k]
     * return: void
     * @Date: 12/13/2020
     */
    private void swim(int k) {
        while (less(k, k / 2)) {
            int j = k / 2;
            exch(k, j);
            k = k / 2;
        }
    }

    /**
     * @Author: ZanderYan
     * @Description: 将位置k处的元素下沉，以恢复堆的结构
     * @Param: [k]
     * return: void
     * @Date: 12/13/2020
     */
    private void sink(int k) {
        while (less(pq[k], pq[2 * k])) {
            int j = 2 * k;
            if (less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * @Author: ZanderYan
     * @Description:
     * @Param: [i, j]
     * @return: void
     * @Date: 12/13/2020
     */
    private void exch(int i, int j) {
        key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
    * @Author: ZanderYan
    * @Description: 比较m和n的大小，若m比n小，返回true
    * @Param: [m, n]
    * @return: boolean
    * @Date: 12/13/2020
    */
    private boolean less(Comparable m, Comparable n) {
        return m.compareTo(n) < 0;
    }


}