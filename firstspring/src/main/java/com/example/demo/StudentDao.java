package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDao implements StudentService 
{
	
	
	@Autowired
	StudentRepo sr;

	@Override
	public void reg(Student s1) 
	{
		sr.save(s1);
		
	}

	@Override
	public List<Student> display() {
		return sr.findAll();
	}

	@Override
	public void delemp(int id) 
	{
		sr.deleteById(id);
		
	}

	@Override
	public Student getsingledata(int id) 
	{
		Student s = sr.findByid(id);
		return s;
	}

	@Override
	public Student update(Student s) 
	{
		Student ss = sr.save(s);
		return ss;
	}



}
