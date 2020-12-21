package com.algorithm.sort;

/**
 * @author: Chris Bosh
 * @date: 2020/12/21 22:56
 * @description: 选择排序
 */
public class SelectionSort extends AbstractSort{
    /**
     * @param a
     *
     * 不断选择右边元素中最小值，依次放在左边
     * 大约 N^2/2次比较和N次交换
     */
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min=i;
            for (int j = i+1; j < a.length; j++) {
                if(less(a[j],min)){
                    min=j;
                }
            }
            exch(a,i,min);

        }
    }
}
