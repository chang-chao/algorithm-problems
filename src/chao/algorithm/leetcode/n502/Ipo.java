package chao.algorithm.leetcode.n502;

import java.util.ArrayList;
import java.util.List;

public class Ipo {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    int currentW = W;
    List<Integer> p = new ArrayList<>();
    while (p.size() < k) {
      int currentProject = -1;
      int currentMaxProfit = 0;
      for (int i = 0; i < Profits.length; i++) {
        if (p.contains(i) || Capital[i] > currentW || Profits[i] < currentMaxProfit) {
          continue;
        }
        currentProject = i;
        currentMaxProfit = Profits[i];
      }

      if (currentProject == -1) {
        break;
      }

      p.add(currentProject);
      currentW += Profits[currentProject];
    }
    return currentW;
  }
}
