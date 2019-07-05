'''
求平方根，精确到小数点后6位
'''


def square_root(x: int) -> int or float:

    low = 0
    high = x
    mid = (high + low) >> 1

    # 退出条件不能是int(mid * 10**6) == mid * 10**6
    while abs(mid**2 - x) >= 10**-6:
        print(mid)
        if mid**2 > x:
            high = mid
        else:
            low = mid
        mid = (high + low) / 2
    return round(mid, 6)


print(square_root(14))
