'''
二分查找变体问题
'''
from typing import List


def bsearch_left_direct(nums: List[int], target: int) -> int:
    '''
    直观版：查找第一个值等于给定值的元素，若没有则返回-1
    '''
    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (high + low) >> 1
        if nums[mid] > target:
            high = mid - 1
        elif nums[mid] < target:
            low = mid + 1
        else:
            if mid == 0 or nums[mid - 1] != target:
                return mid
            else:
                high = mid - 1
    return -1


def bsearch_left(nums: List[int], target: int) -> int:
    '''
    查找第一个值等于给定值的元素，若没有则返回-1
    思路：nums[mid] == target，索性减1，跳出循环前最终加1，存在(low < len(nums))且输出
    '''
    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (high + low) >> 1
        if (nums[mid] >= target):
            high = mid - 1
        else:
            low = mid + 1

    if low < len(nums) and nums[low] == target:
        return low
    else:
        return -1


# print(bsearch_left_indirect([3, 4, 5, 5, 5, 5, 6, 7, 7, 8, 9], 5))


def bsearch_right(nums: List[int], target: int) -> int:
    '''
    查找最后一个值等于给定值的元素，若没有则返回-1
    思路：nums[mid] == target，索性加1，跳出循环前最终减1，存在(high >= 0)且输出
    '''

    low, high = 0, len(nums) - 1
    while low <= high:
        mid = (high + low) // 2
        if nums[mid] <= target:
            low = mid + 1
        else:
            high = mid - 1

    if high >= 0 and nums[high] == target:
        return high
    else:
        return -1


# print(bsearch_right_indirect([3, 4, 5, 5, 5, 5, 6, 7, 7, 7, 8, 9], 5))


def bsearch_first_right(nums: List[int], target: int) -> int:
    '''
    查找第一个大于等于给定值的元素，若没有则返回-1
    '''

    low, high = 0, len(nums) - 1
    while low <= high:
        mid = (high + low) // 2
        if nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1

    if low < len(nums) and nums[low] >= target:
        return low
    else:
        return -1


# print(bsearch_first_right([3, 4, 5, 5, 5, 5, 7, 7, 7, 8, 9], 6))


def bsearch_last_left(nums: List[int], target: int) -> int:
    '''
    查找最后一个小于等于给定值的元素，若没有则返回-1
    '''

    low, high = 0, len(nums) - 1
    while low <= high:
        mid = (high + low) // 2
        if nums[mid] <= target:
            low = mid + 1
        else:
            high = mid - 1

    if high >= 0 and nums[high] <= target:
        return high
    else:
        return -1


print(bsearch_last_left([3, 4, 5, 5, 5, 5, 7, 7, 7, 8, 9], 6))