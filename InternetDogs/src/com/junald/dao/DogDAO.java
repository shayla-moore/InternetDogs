package com.junald.dao;

import java.util.List;
import com.junald.model.Dog;

public interface DogDAO {
	
	public void addDog( Dog dog );
	public void deleteDog( int dogId );
	public void updateDog( Dog dog );
	public List<Dog> getAllDogs();
	public Dog getDogById( int dogId );
	
}
