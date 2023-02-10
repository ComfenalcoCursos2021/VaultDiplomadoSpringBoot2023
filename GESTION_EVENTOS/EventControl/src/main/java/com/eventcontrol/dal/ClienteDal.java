package com.eventcontrol.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcontrol.entity.ClienteEntity;
import com.eventcontrol.repository.IClienteRepository;

@Service
public class ClienteDal {
	@Autowired
	private IClienteRepository clienteRepository;

	public List<ClienteEntity> findAll() {
		return this.clienteRepository.findAll();
	}

	public ClienteEntity findById(long id) {
		return this.clienteRepository.findById(id).get();
	}

	public ClienteEntity save(ClienteEntity entity) {
		return this.clienteRepository.save(entity);
	}

	public ClienteEntity update(ClienteEntity entity)  {
		/*if(!this.clienteRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.clienteRepository.findById(entity.getId())
				.map( x -> {
					x.setEmail(entity.getEmail());
					x.setNombre(entity.getNombre());
					x.setNumIdentificacion(entity.getNumIdentificacion());
					return this.clienteRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.clienteRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.clienteRepository.deleteById(id);
	}
}
