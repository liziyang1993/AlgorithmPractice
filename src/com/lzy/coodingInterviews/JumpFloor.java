package com.lzy.coodingInterviews;

public class JumpFloor {

    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target ==1 || target == 2) return target;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor().JumpFloor(4));
    }
}
