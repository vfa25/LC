'''
查找有序数组中是否存在某一相同元素，有则返回索引
'''

from typing import List


def bsearch(nums: List[int], target: int) -> int:
    return bsearch_internally(nums, 0, len(nums) - 1, target)


def bsearch_internally(nums: List[int], low: int, high: int,
                       target: int) -> int:
    if low > high:
        return

    mid = low + int((high - low) >> 1)
    print(nums[mid])
    if nums[mid] == target:
        return mid
    elif nums[mid] > target:
        return bsearch_internally(nums, low, mid - 1, target)
    else:
        return bsearch_internally(nums, mid + 1, high, target)


print(bsearch([3, 4, 5, 6, 7, 8, 9, 10], 7))
