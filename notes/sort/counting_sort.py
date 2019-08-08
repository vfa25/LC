'''
计数排序
'''

from typing import List
# https://docs.python.org/zh-cn/3/library/itertools.html
import itertools


def counting_sort(a: List[int]):
    if len(a) <= 1:
        return

    # 初始化 max(a) + 1 个元素的列表
    counts = [0] * (max(a) + 1)
    for num in a:
        counts[num] += 1
    # a中有counts[i]个数不大于i
    counts = list(itertools.accumulate(counts))

    # 临时数组，存储排序后的结果
    a_sorted = [0] * len(a)
    for num in reversed(a):
        # reversed以稳定排序
        index = counts[num] - 1
        a_sorted[index] = num
        counts[num] -= 1

    a[:] = a_sorted


if __name__ == "__main__":
    a1 = [1, 2, 3, 4]
    counting_sort(a1)
    print(a1)

    a2 = [1, 1, 1, 1]
    counting_sort(a2)
    print(a2)

    a3 = [4, 5, 0, 9, 3, 3, 1, 9, 8, 7]
    counting_sort(a3)
    print(a3)
