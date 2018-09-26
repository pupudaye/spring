package org.pl.blockchain.entity;

import java.util.Date;

public class Person {

	private Integer id;
	private String name;
	private String sex;
	private Date registerDate;
	
	private static volatile  Person user;
	/**
	 * 默认构造bean
	 */
	public Person(){
	}
	
	/**
	 * 带参数构造bean
	 * @param id
	 * @param name
	 * @param registerDate
	 */
	public Person(Integer id, String name, Date registerDate) {
		this.id = id;
		this.name = name;
		this.registerDate = registerDate;
	}
	
	/**
	 * 静态工厂方法构造bean
	 * @return
	 */
	public static Person createStaticPerson(){
		if(user==null){
			synchronized (Person.class) {
				if(user==null){
					user=new Person();
					user.setName("createStaticPerson");
				}
			}
		}
		return user;
	}
	/**
	 * 动态工厂方法构造bean
	 * @return
	 */
	public Person createDynamicPerson(Date date){
		return new Person(12,"createDynamicPerson",date);
	}
	
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
	
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", registerDate=" + registerDate + "]";
	}

	

	
	
}
