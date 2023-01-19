package com.example.demo.dal;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositorio.IUserRepositorio;

@Service
public class UserDal {

	private IUserRepositorio repo;
	
	public UserDal(IUserRepositorio repo) {
		this.repo = repo;
	}
	
	
	public List<UserEntity> getList(){
		return this.repo.findAll();
	}
	
	public UserEntity guardar(UserEntity nuevoUsuario) {		
		return this.repo.saveAndFlush(nuevoUsuario);
	}
	
	public boolean borrar(Long id) {
		try {
			this.repo.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
