'''
快速排序
'''

from typing import List


def quick_sort(a: List[int]):
    quick_sort_between(a, 0, len(a) - 1)


def quick_sort_between(a: List[int], low: int, high: int):
    if low < high:
        # 获取分治点
        pivot = partition(a, low, high)
        quick_sort_between(a, low, pivot - 1)
        quick_sort_between(a, pivot + 1, high)


def partition(a: List[int], low: int, high: int):
    pivot = a[high]
    i, j = low, low
    while j <= high:
        if a[j] < pivot:
            a[i], a[j] = a[j], a[i]
            i += 1
        j += 1
    a[i], a[j - 1] = a[j - 1], a[i]
    return i


A = [4, 3, 4, 5, 6, 2, 1, 7]
quick_sort(A)
print(A)