package com.xebia.myapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="person")
/*@SequenceGenerator(name="seq_gen", sequenceName="person_id_seq")*/
public class Person {

	public Person() {
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Id
    /*@GeneratedValue(generator="seq_gen", strategy=GenerationType.SEQUENCE)*/
    private Integer id;
    
	@Column
	@NotEmpty(message="Name cannot be empty")
    private String name;
    
	@Column
    private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
    
   
}
