package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionMedianFinder {
    /*
    * 核心思路：使用两个堆（难点是怎么保证两个堆的元素个数差值小于等于1）
    * 大顶堆（矮堆）：存放每一个新来的元素，当元素个数差值>=2时，将堆顶元素给小顶堆
    * 小顶堆（高堆）：当元素个数差值>=2时，将堆顶元素给大顶堆
    * 中位数：就是矮堆中取出最高的，高堆中取出最矮的
    * 重要约束：高堆中的最小值要>=矮堆中的最大值
    * */
    public static class MedianFinder {
        // 初始化两个堆
        private PriorityQueue<Integer> low;
        private PriorityQueue<Integer> high;
        public MedianFinder() {
            this.low =  new PriorityQueue<>((a, b) -> b - a);
            this.high = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 新来的元素要先放入矮堆进行过滤，把有潜力的挑出来
            low.offer(num);
            high.offer(low.poll());
            if (high.size() - low.size() > 1) {
                low.offer(high.poll());
            } else if (low.size() - high.size() > 1) {
                high.offer(low.poll());
            }
        }

        public double findMedian() {
            if (low.size() > high.size()) {
                return low.peek();
            } else if (low.size() < high.size()) {
                return high.peek();
            } else {
                return (low.peek() + high.peek()) / 2.0;
            }
        }
    }
}
