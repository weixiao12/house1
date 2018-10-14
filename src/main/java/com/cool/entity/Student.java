package com.cool.entity;

import lombok.*;

/**
 * @Auther: cjc 2018/8/27 0027
 */
@Data
public class Student {
	private String stuName;


	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.setStuName("zs");
		Student stu2 = new Student();
		stu2.setStuName("zs");
		System.out.println(stu1.equals(stu2));
	}



}
