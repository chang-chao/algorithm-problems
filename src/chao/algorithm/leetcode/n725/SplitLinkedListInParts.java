package chao.algorithm.leetcode.n725;

public class SplitLinkedListInParts {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    int totalSize = 0;
    ListNode currentNode = root;
    while (currentNode != null) {
      totalSize++;
      currentNode = currentNode.next;
    }

    int partSize = totalSize / k;
    int remains = totalSize % k;
    ListNode[] result = new ListNode[k];
    currentNode = root;
    for (int partNo = 0; partNo < k; partNo++) {
      result[partNo] = currentNode;
      int currentPartSize = partSize;
      if (partNo < remains) {
        currentPartSize++;
      }

      for (int i = 0; i < currentPartSize - 1; i++) {
        currentNode = currentNode.next;
      }
      if (currentPartSize > 0) {
        ListNode temp = currentNode;
        currentNode = currentNode.next;
        temp.next = null;

      }
    }
    return result;
  }

}
