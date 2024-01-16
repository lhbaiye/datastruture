package org.example.datastructure.sort.bubble;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description 冒泡排序
 * @date 2023/12/10 22:51:44
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - j; j++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean change = false;
        for (int i = 0; i < arr.length - 1; i++) {
            change = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
    }

    /**
     * 大量数据排序时间测试
     */
    @Test
    public void bulkDataSort() {
        int max = 80_000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }

        Instant startTime = Instant.now();
        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public void processSelectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            if (minIndex == i) {
                // 如果最小值未发生改变，则不需要执行后面的交换了
                continue;
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第 " + (i + 1) + " 轮排序后：" + Arrays.toString(arr));
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    @Test
    public void processDemo2() {
        int arr[] = {101, 34, 119, 1};
        System.out.println("原始数组：" + Arrays.toString(arr));
        processSelectSort2(arr);
    }

    public void shellSort(int[] arr) {
        int temp = 0;
        // 第 1 层循环：得到每一次的增量步长
        for (int gap = arr.length / 2; gap > 0; gap/=2) {
            // 外层排序，指的是从这里的增量是最小的，然后不放过每一个元素
            // 这里的每一个都是 无序数组的 第一个
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public void moveShellSort(int[] arr) {
        // 第 1 层循环：得到每一次的增量步长
        // 增量并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            /**
             这里的内层循环，除了是获得每一组的值（按增量取），
             移动法使用的是简单插入排序的算法 {@link InsertionSortTest#processSelectSort2(int[])}
             唯一不同的是，这里的组前一个是按增量来计算的
             */
            // 每一轮，都是针对某一个组的插入排序中：待排序的起点
            for (int i = gap; i < arr.length; i++) {
                int currentInsertValue = arr[i]; // 无序列表中的第一个元素
                int insertIndex = i - gap; // 有序列表中的最后一个元素
                while (insertIndex >= 0
                        && currentInsertValue < arr[insertIndex]) {
                    // 比较的数比前一个数小，则前一个往后移动
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                // 对找到的位置插入值
                arr[insertIndex + gap] = currentInsertValue;
            }
            System.out.println("增量为 " + gap + " 的这一轮排序后：" + Arrays.toString(arr));
        }
    }

    /**
     * 移动法，大数据量测试速度
     */
    @Test
    public void moveBulkDataSort() {
        int max = 80_000;
//        int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }

        Instant startTime = Instant.now();
        moveShellSort(arr);
//        System.out.println(Arrays.toString(arr));
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public void processQuickSort(int[] arr, int left, int right) {
        /*
         基本思想：选择一个基准值，将基准值小分成一组，比基准值大的分成一组。
         这里的实现思路：
            1. 挑选的基准值为数组中间的值
            2. 中间值就把数组分成了两组
            3. 左边一组，从左到右，挨个与 基准值 比较，找出比基准值大的值
            4. 右边一组，从右到左，挨个与 基准值 比较，找出比基准值小的值
            5. 左右两边各找到一个值，那么就让这两个值进行交换
            6. 然后继续找，直到左右两边碰到，这一轮就结束。这一轮就称为快速排序
            7. 继续对分出来的小组，进行上述的快速排序操作，直到组内只剩下一个数时，则排序完成

            l ------------ pivot --------------- r
            一组从左往右找               一组从右往左找
         **/
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换完以后， l一定小于pivot， r一定大于pivot
            l++;
            r--;
        }
        // 当一轮找完后，没有找到，则是中间值时，
        // 需要让他们插件而过，也就是重新分组，中间值不再参与分组
        // 否则，在某些情况下，会进入死循环
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            processQuickSort(arr, left, r);
        }
        if (right > l) {
            processQuickSort(arr, l, right);
        }
    }

    /**
     * <pre>
     *  最难的是合并,所以可以先完成合并的方法，此方法请参考 基本思想 和 思路分析中的图解来完成
     *
     * </pre>
     *
     * @param arr   要排序的原始数组
     * @param left  因为是合并，所以要得到左右两边的的数组信息，这个是左侧数组的第一个索引值
     * @param mid   因为是一个数组，标识是第一个数组的最后一个索引，即 mid+1 是右侧数组的第一个索引
     * @param right 右侧数组的结束索引
     * @param temp  临时空间
     */
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 1. 按规则将两个数组合并到 temp 中
        // 定时临时变量，用来遍历数组比较
        int l = left;// 左边数组的初始索引
        int r = mid + 1; //右边数组的初始索引
        int t = 0; //temp数组的当前最后一个有效数组索引
        while (l <= mid && r <= right) {
            // 如果左边的比右边的小，则将左边的该元素填充到 temp 中
            // 并移动 t++,l++,好继续下一个
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                l++;
            } else {
                temp[t] = arr[r];
                r++;
            }
            t++;
        }
        // 2. 如果有任意一边的数组还有值，则依序将剩余数据填充到 temp 中
        // 如果左侧还有值
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        // 如果右侧还有值
        while (r <= right) {
            temp[t++] = arr[r++];
        }
        // 3. 将 temp 数组，拷贝到原始数组
        // 注意：只拷贝当前有效数据到对应的原始数据中
        int tempL = left; // 从左边开始拷贝
        t = 0;  // temp 中的有效值，可以通过下面的 right 判定，因为合并两个数组到 temp 中，最大值则是 right
        System.out.println("tempL=" + tempL + "; right=" + right);
        while (tempL <= right) {
            arr[tempL] = temp[t];
            tempL++;
            t++;
        }
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 先分解左侧
            mergeSort(arr, left, mid, temp);
            // 再分解右侧
            mergeSort(arr, mid + 1, right, temp);
            // 由于是递归，合并这里一定是栈顶的先执行
            // 第一次：left = 0,right=1
            // 第二次：left = 2,right=3
            // 第三次：left = 0，right=3
//            System.out.println("left=" + left + "；right=" + right);
            merge(arr, left, mid, right, temp);
        }
    }

    public void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int tempIndex = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[right]) {
                temp[tempIndex++] = arr[l++];
            } else {
                temp[tempIndex++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[tempIndex++] = arr[l++];
        }
        while (r <= right) {
            temp[tempIndex++] = arr[r++];
        }
        tempIndex = 0;
        int tempL = left;
        while (tempL <= right) {
            arr[tempL++] = temp[tempIndex++];
        }
    }

    public void radixSort(int[] arr) {
        // 得到数组中最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        // 定义桶子
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[bucket.length];
        for (int k = 1, n = 1; k <= maxLength; k++, n*=10) {
            // 进行桶排序
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = arr[i] / n % 10;
                bucket[bucketIndex][bucketCounts[bucketIndex]] = arr[i];
                // 标识该桶元素多了一个
                bucketCounts[bucketIndex]++;
            }
            // 放回原数组中
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCounts[i] == 0){
                    continue;
                }
                for (int j = 0; j < bucketCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketCounts[i] = 0;
            }
        }
    }

    public void radixSort2(int[] arr) {
        // 先获取最大位数
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        int maxLength = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[bucket.length];
        for (int k = 0, n = 1; k < maxLength; k++, n*=10) {
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = arr[i] / n * 10;
                bucket[bucketIndex][bucketCounts[bucketIndex]] = arr[i];
                bucketCounts[bucketIndex]++;
            }
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCounts[i] == 0) {
                    continue;
                }
                for (int j = 0; j < bucketCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                // 取完后，重置该桶的元素个数为 0 ，下一次才不会错乱数据
                bucketCounts[i] = 0;
            }
        }
    }


    public void sort(int[] arr) {
        // =====  1. 构造初始堆
        // 从第一个非叶子节点开始调整
        // 4,9,8,5,6
        //  adjustHeap(arr, arr.length / 2 - 1, arr.length);

        // 循环调整
        // 从第一个非叶子节点开始调整，自低向上
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 第一轮调整了 3 个堆后：结果为：9，6,8,5,4
        // System.out.println(Arrays.toString(arr));
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 要将这三个数（堆），调整为一个大顶堆
            // i 的左节点小于右节点
            // k+1 < length : 当调整长度为 2 时，也就是数组的前两个元素，其实它没有第三个节点了，就不能走这个判定
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 右边的大，则将 k 变成最大的那一个
            }
            // 如果左右中最大的一个数，比 i 大。则调整它
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k; // i 记录被调整后的索引。
            } else {
                break;
                // 由于初始堆，就已经是大顶堆了，每个子堆的顶，都是比他的左右两个大的
                // 当这里没有进行调整的话，那么就可以直接退出了
                // 如果上面进行了调整。那么在初始堆之后，每次都是从 0 节点开始 自左到右，自上而下调整的
                //    就会一层一层的往下进行调整
            }
        }
        arr[i] = temp;
    }


}
