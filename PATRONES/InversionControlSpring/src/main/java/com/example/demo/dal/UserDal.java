package com.example.demo.dal;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<UserEntity> getListLike(String nombreLike){
		return this.repo.findByNombreLikeOrderByIdDesc(nombreLike);
	}
	
	public List<UserEntity> getListContains(String nombreLike){
		return this.repo.findByNombreContainsOrderByEmailDesc(nombreLike);
	}
	
	public UserEntity actualizar(UserEntity user, long idActualizar) {
		
		return this.repo.findById(idActualizar)
				.map(u -> {
					u.setApellido(user.getApellido());
					u.setEdad(user.getEdad());
					u.setNombre(user.getNombre());
					u.setEmail(user.getEmail());
					return this.repo.save(u);
				}).get();
	}
	
	public UserEntity upsert(UserEntity user) {
		return this.repo.saveAndFlush(user);
	} 
	
	public UserEntity actualizar(UserEntity user) {		
		//return this.repo.saveAndFlush(user);		
		return this.repo.findById(user.getId())
				.map(u -> {
					u.setApellido(user.getApellido());
					u.setEdad(user.getEdad());
					u.setNombre(user.getNombre());
					u.setEmail(user.getEmail());
					return this.repo.save(u);
				}).get();
	}
	@Transactional
	public void guardarBulk(List<UserEntity> usuariosNuevos) {
		//usuariosNuevos.stream().forEach(u->u.setId(0L));
		usuariosNuevos.stream().forEach(u -> this.repo.save(u));
	}
	
}
