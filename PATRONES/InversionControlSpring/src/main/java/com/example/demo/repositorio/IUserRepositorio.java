package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserEntity;

@Repository
public interface IUserRepositorio extends JpaRepository<UserEntity,Long>{

	@Query("Select u From UserEntity u Where ?1 < u.edad and u.edad < ?2")
	//@Query(value="SELECT * FROM USERS WHERE  ? < EDAD AND EDAD < ? ", nativeQuery = true )
	List<UserEntity> findByEdad(int edad1, int edad2);
	
	List<UserEntity> findByNombre(String nombre);	
	
	List<UserEntity> findByApellido(String nombre);
	
	List<UserEntity> findByNombreLikeOrderByIdDesc(String nombre);
	
	
	List<UserEntity> findByNombreContainsOrderByEmailDesc(String nombre);
	
	//SELECT * FROM USERS WHERE (18 < edad  and edad < 22) or (edad = 18)
	@Query("SELECT u FROM UserEntity u WHERE (:edadIni < u.edad and u.edad < :edadFin) or (u.edad = :edadIni)")
	List<UserEntity> buscarRangoEdades(@Param("edadIni") int edadInicial,@Param("edadFin") int edadFinal);
	
	
	//@Query(value="SELECT u.* FROM users u WHERE nombre = ? or apellido = ?", nativeQuery = true )
	@Query("SELECT u FROM UserEntity u WHERE u.nombre = ?1 or u.apellido = ?2")
	List<UserEntity> bucarNombreApellido(String nombre, String apellido);
	
	List<UserEntity> findByNombreOrApellido(String nombre, String apellido);
	
	List<UserEntity> findByEdadBetween(int edadInicial, int edadFinal);
	
	
	
}
