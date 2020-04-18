package com.lzy.interview;

public class Test {

    int findMin(int[] array) {
        int left = 0, right = array.length;
        int target = 0;
        while (left < right) {
            int midle = (left + right) / 2;
            if (array[midle] < array[midle + 1] && array[midle] > array[midle - 1]) left = midle + 1;
            else if (array[midle] > array[midle + 1] && array[midle] < array[midle - 1]) right = midle - 1;
            else if (array[midle] < array[midle + 1] && array[midle] < array[midle - 1]) {
                target = midle;
                break;
            } else if (array[midle] > array[midle + 1] && array[midle] > array[midle - 1]) {
                target = midle + 1;
                break;
            }

        }
        return target;
    }


}
