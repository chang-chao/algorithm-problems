package chao.algorithm.leetcode.n24;

public class SwapNodesInPairs {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode swapPairs(ListNode head) {

    ListNode prevNode = null;
    ListNode firstNode = null;
    if (head != null) {
      firstNode = head;
    }

    ListNode secondNode = null;
    if (firstNode != null) {
      secondNode = firstNode.next;
    }

    if (secondNode == null) {
      return head;
    }
    ListNode resultHead=secondNode;
    while (secondNode != null) {
      ListNode nextNode = secondNode.next;
      if (prevNode != null) {
        prevNode.next = secondNode;

      }

      secondNode.next = firstNode;
      firstNode.next = nextNode;

      prevNode = firstNode;
      firstNode = nextNode;
      secondNode = firstNode == null ? null : firstNode.next;
    }

    return resultHead;
  }
}
