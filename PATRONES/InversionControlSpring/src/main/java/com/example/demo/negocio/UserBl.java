package com.example.demo.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dal.UserDal;
import com.example.demo.dtos.UserDto;
import com.example.demo.entities.UserEntity;

@Service
public class UserBl {

	private UserDal userDal;

	public UserBl(UserDal userDal) {
		this.userDal = userDal;
	}

	public List<UserDto> getUserList() {
		List<UserDto> usersDto = new ArrayList<>();
		
		List<UserEntity> entities = this.userDal.getList();
		
		for (UserEntity userEntity : entities) {
			usersDto.add(new UserDto(userEntity));
		}
		return usersDto;
	}
	
	public UserDto guardar(UserDto nuevoUsuario) {
		UserEntity nuevo = new UserEntity();		 
		nuevo.setApellido(nuevoUsuario.getApellido());
		nuevo.setNombre(nuevoUsuario.getNombre());
		nuevo.setEmail(nuevoUsuario.getEmail());
		
		UserEntity userEntity = this.userDal.guardar(nuevo);
		
		return new UserDto(userEntity);
	}
	
	public boolean borrar(Long id) {
		return this.userDal.borrar(id);
	}
}
