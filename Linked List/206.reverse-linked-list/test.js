/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
  var cur = head;
  var prev = null;
  while (cur) {
    var tem = cur.next;
    cur.next = prev;
    prev = cur;
    cur = tem;
  }
  return prev;
};