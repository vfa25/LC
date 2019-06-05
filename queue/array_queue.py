'''
    Queue based upon array
    用数组实现队列
'''

from typing import Optional


class ArrayQueue:
    def __init__(self, capacity: int):
        self._items = []
        self._capacity = capacity
        self._head = 0
        self._tail = 0

    def enqueue(self, item) -> bool:
        if self._capacity == self._tail:
            if self._head == 0:
                return False
            for i in range(self._tail - self._head):
                self._items[i] = self._items[i + self._head]
            self._tail = self._tail - self._head
            self._head = 0

        self._items.insert(self._tail, item)
        self._tail += 1
        return True

    def dequeue(self) -> Optional[str]:
        if self._head == self._tail:
            return None
        else:
            item = self._items[self._head]
            self._head += 1
            return item

    def __repr__(self) -> str:
        return " ".join(
            str(item) for item in self._items[self._head:self._tail])


if __name__ == '__main__':
    queue = ArrayQueue(10)
    for i in range(9):
        queue.enqueue(i)
    print(queue)
    for _ in range(3):
        queue.dequeue()
    print(queue)
