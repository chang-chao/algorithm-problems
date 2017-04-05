package chao.algorithm.leetcode.n502;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ipo {
  public int findMaximizedCapital(int k, int W, final int[] Profits, final int[] Capital) {
    int size = Profits.length;
    Integer[] capOrder = new Integer[size];
    for (int i = 0; i < size; i++) {
      capOrder[i] = i;
    }
    Arrays.sort(capOrder, (o1, o2) -> Capital[o1] - Capital[o2]);

    PriorityQueue<Integer> profitQueue = new PriorityQueue<>(size);
    int currentW = W;
    int pSize = 0;
    int currentCapOrder = 0;
    while (pSize < k) {
      while (currentCapOrder < size && Capital[capOrder[currentCapOrder]] <= currentW) {
        profitQueue.add(-Profits[capOrder[currentCapOrder++]]);
      }
      if (profitQueue.isEmpty()) {
        return currentW;
      }

      currentW -= profitQueue.poll();
      pSize++;
    }
    return currentW;
  }
}
