package com.yzsjy.code.sort;

/**
 * @author SUNJUNYAN
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 1, 2, 3, 4, 1, 3, 2, 2, 9, 0};
        heapSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    public static void heapSort(int[] a) {
        //创建堆
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从左至右调整结构
            adjustHeap(a, i, a.length);
        }

        //调整堆结构，交换堆顶元素与末尾元素
        for (int i = a.length - 1; i > 0; i--) {
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;

            //重新对堆进行调整
            adjustHeap(a, 0, i);
        }
    }

    /**
     * 调整堆
     * @param a 待排序列
     * @param parent 父结点
     * @param length 待排序列尾元素索引
     */
    public static void adjustHeap(int[] a, int parent, int length) {
        //将tmp作为父节点
        int tmp = a[parent];
        //左孩子
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            //如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选择右孩子结点
            if (rChild < length && a[lChild] < a[rChild]) {
                lChild++;
            }
            //如果父节点的值已经大于孩子结点的值，则直接结束
            if (tmp >= a[lChild]) {
                break;
            }
            //把孩子结点的值赋给父节点
            a[parent] = a[lChild];
            //选取孩子结点的值赋给父节点
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        a[parent] = tmp;
    }
}
