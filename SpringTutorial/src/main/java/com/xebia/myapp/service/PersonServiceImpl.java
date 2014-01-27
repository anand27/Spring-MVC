package com.xebia.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.myapp.dao.PersonDao;
import com.xebia.myapp.domain.Person;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	@Override
	public List<Person> getPersons() {
		return personDao.getPersons();
	}

	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}

	@Override
	public Person getPerson(Integer id) {
		return personDao.getPerson(id);
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	public void deletePerson(Integer id) {
		personDao.deletePerson(id);
	}
	
	

}
