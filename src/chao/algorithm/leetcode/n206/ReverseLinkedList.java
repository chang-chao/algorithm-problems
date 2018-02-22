package chao.algorithm.leetcode.n206;

public class ReverseLinkedList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode currentHeadNode = head;
    ListNode newHeadNode = currentHeadNode.next;
    currentHeadNode.next = null;
    while (newHeadNode != null) {
      ListNode nextNewHeadNode = newHeadNode.next;
      newHeadNode.next = currentHeadNode;
      currentHeadNode = newHeadNode;
      newHeadNode = nextNewHeadNode;
    }
    return currentHeadNode;
  }

}
