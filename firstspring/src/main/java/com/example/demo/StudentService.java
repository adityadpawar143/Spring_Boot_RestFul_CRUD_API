package com.example.demo;

import java.util.List;

public interface StudentService 
{
	void reg(Student s1);
	
	List<Student> display();
	
	void delemp(int id);
	
	Student getsingledata(int id);

	Student update(Student s);
}
