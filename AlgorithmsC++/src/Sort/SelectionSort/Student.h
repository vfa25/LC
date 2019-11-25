/*
 * Student.h
 *
 *  Created on: Nov 26, 2019
 *      Author: abukii
 */

#ifndef SORT_SELECTIONSORT_STUDENT_H_
#define SORT_SELECTIONSORT_STUDENT_H_

#include <iostream>

using namespace std;

//结构体
struct Student {

	string name;
	int score;

	//运算符重载
	bool operator<(const Student &otherStudent) {

		return score < otherStudent.score;
		// 分数相同，以名称字典序排列
//		return score != otherStudent.score ? score < otherStudent.score : name < otherStudent.name;
	}

	//友元函数以访问private和protected成员
	friend ostream& operator<<(ostream &os, const Student &student) {

		os<<"Student: "<<student.name<<" "<<student.score<<endl;
		return os;
	}
};



#endif /* SORT_SELECTIONSORT_STUDENT_H_ */
