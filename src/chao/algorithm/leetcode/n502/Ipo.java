package chao.algorithm.leetcode.n502;

import java.util.PriorityQueue;

public class Ipo {
  public int findMaximizedCapital(int k, int W, final int[] Profits, final int[] Capital) {
    int size = Profits.length;
    PriorityQueue<int[]> capQueue = new PriorityQueue<>(size, (o1, o2) -> Capital[o1[1]] - Capital[o2[1]]);
    PriorityQueue<int[]> profitQueue = new PriorityQueue<>(size, (o1, o2) -> Profits[o2[1]] - Profits[o1[1]]);
    for (int i = 0; i < size; i++) {
      capQueue.add(new int[] { Capital[i], i });
    }
    int currentW = W;
    int pSize = 0;
    while (pSize < k) {
      while (!capQueue.isEmpty() && capQueue.peek()[0] <= currentW) {
        int[] project = capQueue.poll();
        int index = project[1];
        profitQueue.add(new int[] { Profits[index], index });
      }

      int[] nextProject = profitQueue.poll();
      if (nextProject == null) {
        return currentW;
      }
      currentW += nextProject[0];
      pSize++;
    }
    return currentW;
  }
}
