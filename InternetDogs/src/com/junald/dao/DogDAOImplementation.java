package com.junald.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.junald.model.Dog;
import com.junald.util.DBUtil;
 
public class DogDAOImplementation implements DogDAO {
 
    private Connection conn;
 
    public DogDAOImplementation() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addDog(Dog dog) {
		try {
			
			String query = "insert into Dog (dname, breed, age, birthday, owner_name) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			
			preparedStatement.setString( 1, dog.getdName() );
			preparedStatement.setString( 2, dog.getBreed() );
			preparedStatement.setInt( 3, dog.getAge() );
			preparedStatement.setString( 4, dog.getBirthday() );
			preparedStatement.setString( 5 , dog.getOwner() );
			
			preparedStatement.executeUpdate();
	        preparedStatement.close();
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDog(int dogId) {
		try {
			
			String query = "delete from Dog where dog_id=?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, dogId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDog(Dog dog) {
		try{
			
			String query = "UPDATE Dog SET dname=?, breed=?, age=?, birthday=?, owner_name=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);	
			
			preparedStatement.setString(1,  dog.getdName());
			preparedStatement.setString(2, dog.getBreed());
			preparedStatement.setInt(3, dog.getAge());
			preparedStatement.setString(4, dog.getBirthday());
			preparedStatement.setString(5, dog.getOwner());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public List<Dog> getAllDogs() {
		List<Dog> dogs = new ArrayList<Dog>();
		try {
			
			String query = "SELECT * FROM Dog";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while( resultSet.next())
			{
				Dog dog = new Dog();
				dog.setDogId( resultSet.getInt("dog_id"));
				dog.setdName( resultSet.getString("dname"));
				dog.setBreed( resultSet.getString("breed"));
				dog.setAge( resultSet.getInt("age"));
				dog.setBirthday( resultSet.getString("birthday"));
				dog.setOwner( resultSet.getString("owner_name"));
				
				dogs.add(dog);				
			}
			
			resultSet.close();
			statement.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dogs;
	}

	@Override
	public Dog getDogById(int dogId) {
		Dog dog = new Dog();
		try {
			String query = "SELECT * from Dog WHERE dog_id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, dogId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				dog.setDogId(resultSet.getInt("dog_id"));
				dog.setdName(resultSet.getString("dname"));
				dog.setBreed(resultSet.getString("breed"));
				dog.setAge(resultSet.getInt("age"));
				dog.setBirthday(resultSet.getString("birthday"));
				dog.setOwner(resultSet.getString("owner"));
			}
			
			resultSet.close();
			preparedStatement.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
		}
		
		return dog;
	}
  
 
}