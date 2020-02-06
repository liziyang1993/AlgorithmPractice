package com.lzy.sort;

public class HeapSort {

    public int[] heapSort(int[] nums){

        // 根据输入的数组建立一个堆
        for (int i = nums.length/2-1; i >= 0; i--){
            heapfy(nums, i, nums.length);
        }

        for (int i = nums.length-1; i >= 0; i--){

            //将堆顶元素交换至数组的末尾
            int t = nums[i];
            nums[i] = nums[0];
            nums[0] = t;

            // 将剩余元素重新调整为一个堆
            heapfy(nums, 0, i);
        }

        return nums;
    }

    // 将以nums[i]为根的子树调整为一个大顶堆
    private void heapfy(int nums[], int i, int heapSize){
        int temp = nums[i];
        for (int k = 2*i+1; k < heapSize; k++){
            // 选择左右子节点中值较大的一个。
            if (k+1 < heapSize && nums[k] < nums[k+1]) k++;

            if (nums[k] > temp){
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
                i = k;
            }
            else break;
        }
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(10,100);
        System.out.println("堆排序");
        System.out.println("排序之前：");
        for (int i : nums) System.out.print(i + ",");
        nums = new HeapSort().heapSort(nums);
        System.out.println("\n排序之后：");
        for (int i : nums) System.out.print(i + ",");
    }
}
