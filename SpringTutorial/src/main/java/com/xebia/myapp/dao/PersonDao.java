package com.xebia.myapp.dao;

import java.util.List;

import com.xebia.myapp.domain.Person;

public interface PersonDao {

	public List<Person> getPersons();

	public void addPerson(Person person);
	
	public Person getPerson(Integer id);
	
	public void updatePerson(Person person);
	
	public void deletePerson(int id);
	
}
