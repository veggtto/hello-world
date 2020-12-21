package com.algorithm.sort;

/**
 * @author: Chris Bosh
 * @date: 2020/12/21 22:43
 * @description:
 */
public abstract class AbstractSort<T> {
    public abstract void sort(Comparable<T>[] a);

    public boolean less(Comparable<T> v, Comparable<T> w){
        return v.compareTo((T) w) <0;
    }

    public void exch(Comparable<T>[] a, int i, int j){
        Comparable<T> t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public boolean isSorted(Comparable<T>[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }



}
