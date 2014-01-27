package com.xebia.myapp.service;

import java.util.List;

import com.xebia.myapp.domain.Person;

public interface PersonService {

	public List<Person> getPersons();

	public void addPerson(Person person);

	public Person getPerson(Integer id);

	public void updatePerson(Person person);
	
	public void deletePerson(Integer id);
	
	
}
