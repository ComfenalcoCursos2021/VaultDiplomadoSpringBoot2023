package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserEntity;

@Repository
public interface IUserRepositorio extends JpaRepository<UserEntity,Long>{

	@Query("Select u From UserEntity u Where ?1 < u.edad and u.edad < ?2")
	//@Query(value="SELECT * FROM USERS WHERE  ? < EDAD AND EDAD < ? ", nativeQuery = true )
	List<UserEntity> findByEdad(int edad1, int edad2);
	
	List<UserEntity> findByNombre(String nombre);
	
	
	List<UserEntity> findByApellido(String nombre);
}
