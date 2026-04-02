package heap;

import java.util.*;

public class SolutionTopKFrequent {
    // 注意：是使用大顶堆还是小顶堆是有很大区别的
    /*
     * 大顶堆：时间复杂度是 KlogN
     * 小顶堆：时间复杂度是 NlogK
     * 虽然大顶堆比小顶堆要快，但是小顶堆的优势主要是解决数据流问题， 因为大顶堆需要把所有数据同时放入内存中
     * */
    //public static int[] topKFrequent(int[] nums, int k) {
    //    // 统计频率
    //    Map<Integer, Integer> frequencyMap = new HashMap<>();
    //    for (int num : nums) {
    //        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    //    }
    //    // 使用库函数。维护一个key的小顶堆
    //    PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
    //    // 将元素添加进堆中
    //    for (Integer key : frequencyMap.keySet()) {
    //        smallHeap.offer(key);
    //        if (smallHeap.size() > k) {
    //            smallHeap.poll();
    //        }
    //    }
    //    // 收集结果
    //    int[] ret = new int[k];
    //    for (int i = 0; i < k; i++) {
    //        ret[i] = smallHeap.poll();
    //    }
    //    return ret;
    //}


    /*
     * 使用桶排序进行优化，时间复杂度 N
     * */
    public static int[] topKFrequent(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 核心：一个元素他的频率不可能超过数组长度
        ArrayList<Integer>[] frequencyList = new ArrayList[nums.length + 1];
        for (Integer key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if (frequencyList[freq] == null) {
                frequencyList[freq] = new ArrayList<>();
            }
            frequencyList[freq].add(key);
        }
        int[] ret = new int[k];
        int index = 0;
        for (int i = frequencyList.length - 1; i >= 0; i--) {
            ArrayList<Integer> list = frequencyList[i];
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    ret[index++] = list.get(j);
                    if (index >= k) {
                        return ret;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
