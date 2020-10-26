package com.wf.offer3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wf
 * @create 2020-10-25 15:31
 * @desc
 **/
public class TwoSumDemo {
    public static void main(String[] args) {
        int[] arrs = {2, 7, 9 ,11};
        int target = 16;

        int[] result = twoSum2(arrs, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Hash表
     * @param arrs
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] arrs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            int other = target - arrs[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(arrs[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 时间复杂度 O(N²)
     * @param arrs
     * @param target
     * @return
     */
    private static int[] twoSum(int[] arrs, int target) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (target - arrs[i] == arrs[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
