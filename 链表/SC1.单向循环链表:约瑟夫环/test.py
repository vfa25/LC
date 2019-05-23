""" 
循环链表经典问题：约瑟夫问题，时间复杂度O(m*n)。
若给定总人数，起点位置，方向和每次要跳过的数字，实现一个方法，计算在哪个位置会最终存活。
"""


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class Solution:
    # 构建循环链表
    def create_circle_linkedList(self, n):
        head = Node(1)
        pre = head
        for i in range(2, n + 1):
            newNode = Node(i)
            pre.next = newNode
            pre = newNode
        pre.next = head
        return head

    def filterItem(self, len, num):
        if num == 1:
            print('无路可逃')
        else:
            head = self.create_circle_linkedList(len)
            cur, pre = head, None
            while cur.next != cur:
                # 查找以 cur 起点的 目标结点 的前一个(即共 n-2 次)
                # 不要直接查 目标结点，因为单向循环链表没有前驱指针
                for i in range(num - 1):
                    pre, cur = cur, cur.next
                print('当次循环要干掉的结点位置：' + str(cur.value))
                # 删除目标结点
                pre.next, cur.next, cur = cur.next, None, cur.next
            print('在这个位置存活：' + str(cur.value))


solution = Solution()
solution.filterItem(10, 2)
