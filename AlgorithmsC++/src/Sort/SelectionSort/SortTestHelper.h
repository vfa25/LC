/*
 * SortTestHelper.h
 *
 *  Created on: Nov 26, 2019
 *      Author: abukii
 */

#ifndef SORT_SELECTIONSORT_SORTTESTHELPER_H_
#define SORT_SELECTIONSORT_SORTTESTHELPER_H_

#include <iostream>
#include <ctime>
#include <cassert>

using namespace std;

namespace SortTestHelper {

	// 生成有n个元素的随机数组，每个元素的随机范围为[rangeL, rangeR]
	int* generateRandomArray(int n, int rangeL, int rangeR) {

		assert(rangeL <= rangeR);
		int *arr = new int[n];
		// 随机种子设置
		srand(time(NULL));
		for(int i = 0; i < n; i ++)
			// 取模即偏移量
			arr[i] = rand() % (rangeR - rangeL + 1) + rangeL;

		return arr;
	}

	template<typename T>
	void printArray(T arr[], int n) {

	    for(int i = 0 ; i < n ; i ++)
	        cout<<arr[i]<<" ";
	    cout<<endl;

	    return;
	}
}



#endif /* SORT_SELECTIONSORT_SORTTESTHELPER_H_ */
