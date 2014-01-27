package com.xebia.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xebia.myapp.domain.Person;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersons() {
		return getCurrentSession().createQuery("from Person").list();
	}

	@Override
	public void addPerson(Person person) {
			getCurrentSession().save(person);
	}

	@Override
	public Person getPerson(Integer id) {
		return (Person) getCurrentSession().get(Person.class, id);
	}

	@Override
	public void updatePerson(Person person) {
		getCurrentSession().update(person);
	}
	
	@Override
	public void deletePerson(int id) {
        Person person = getPerson(id);
        if (person != null)
                getCurrentSession().delete(person);
}
	
	

}
