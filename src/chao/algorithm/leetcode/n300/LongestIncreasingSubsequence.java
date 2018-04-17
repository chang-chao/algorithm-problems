package chao.algorithm.leetcode.n300;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    return lengthOfLISInSubArray(0, Integer.MIN_VALUE, 0, nums);
  }

  private int lengthOfLISInSubArray(int currentLength, int currentTail, int start, int[] nums) {
    if (start >= nums.length) {
      return currentLength;
    }

    int currentMaxLenth = currentLength;
    int length1 = lengthOfLISInSubArray(currentLength, currentTail, start + 1, nums);
    if (length1 > currentMaxLenth) {
      currentMaxLenth = length1;
    }

    for (int i = start; i < nums.length; i++) {
      if (nums[i] > currentTail) {

        int length = lengthOfLISInSubArray(currentLength + 1, nums[i], i + 1, nums);
        if (length > currentMaxLenth) {
          currentMaxLenth = length;
        }

      }
    }

    return currentMaxLenth;
  }

}
