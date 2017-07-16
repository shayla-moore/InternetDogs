package com.junald.model;

public class Dog {
	
	private int dogId;
	private String dName;
	private int age;
	private String birthday;
	private String owner;
	private String breed;
	
	/**
	 * @return the dogId
	 */
	public int getDogId() {
		return dogId;
	}
	
	/**
	 * @param dogId the dogId to set
	 */
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	
	/**
	 * @return the dName
	 */
	public String getdName() {
		return dName;
	}
	
	/**
	 * @param dName the dName to set
	 */
	public void setdName(String dName) {
		this.dName = dName;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public String toString() {
        return "Dog [dogId=" + dogId + ", dName=" + dName
                + ", breed=" + breed + ", age=" + age + ", Owner="
                + owner + ", Dog's Birthday=" + birthday + "]";
    }
 

}
