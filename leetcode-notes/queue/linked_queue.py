'''
    Queue based upon linked list
    用链表实现队列
'''

from typing import Optional


class Node:
    def __init__(self, data: str, next=None):
        self._data = data
        self._next = next


class LinkedQueue:
    def __init__(self):
        self._head: Optional[Node] = None
        self._tail: Optional[Node] = None

    def enqueue(self, value: str):
        new_node = Node(value)
        if self._tail:
            self._tail._next = new_node
        else:
            self._head = new_node
        self._tail = new_node

    def dequeue(self) -> Optional[str]:
        if self._head:
            value = self._head._data
            self._head = self._head._next
            if not self._head:
                self._tail = Node
            return value

    def __repr__(self) -> str:
        values = []
        current = self._head
        while current:
            values.append(current._data)
            current = current._next
        return "->".join(value for value in values)


if __name__ == "__main__":
    q = LinkedQueue()
    for i in range(10):
        q.enqueue(str(i))
    print(q)

    for _ in range(3):
        q.dequeue()
    print(q)

    q.enqueue("7")
    q.enqueue("8")
    print(q)
