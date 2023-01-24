package com.example.demo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.example.demo.dal.UserDal;
import com.example.demo.dtos.UserDto;
import com.example.demo.entities.UserEntity;

@Service
public class UserBl {

	private ModelMapper mapper;
	private UserDal userDal;

	public UserBl(UserDal userDal,
			ModelMapper mapper) {
		this.userDal = userDal;
		this.mapper = mapper;
	}

	public List<UserDto> getUserList() {
		List<UserDto> usersDto = new ArrayList<>();
		
		List<UserEntity> entities = this.userDal.getList();
		
		for (UserEntity userEntity : entities) {			
			usersDto.add(mapper.map(userEntity, UserDto.class));
		}
		return usersDto;
	}
	
	public UserDto guardar(UserDto nuevoUsuario) {
		UserEntity nuevo = new UserEntity();		 
		nuevo.setApellido(nuevoUsuario.getApellido());
		nuevo.setNombre(nuevoUsuario.getNombre());
		nuevo.setEmail(nuevoUsuario.getEmail());
		
		UserEntity userEntity = this.userDal.guardar(nuevo);
		
		return mapper.map(userEntity, UserDto.class);
	}
	
	public boolean borrar(Long id) {
		return this.userDal.borrar(id);
	}
	
	public List<UserDto> getListLike(String nombreLike){
		List<UserEntity> usuarios = this.userDal.getListLike(nombreLike);		
		return mapper.map(usuarios, new TypeToken<List<UserDto>>() {}.getType());		
	}
	public List<UserDto> getListContains(String nombreLike){
		List<UserEntity> usuarios = this.userDal.getListContains(nombreLike);		
		return mapper.map(usuarios, new TypeToken<List<UserDto>>() {}.getType());		
	}
	
	
}
