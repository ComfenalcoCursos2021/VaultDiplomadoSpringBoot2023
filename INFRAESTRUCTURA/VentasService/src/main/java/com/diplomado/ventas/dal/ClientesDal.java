


package com.diplomado.ventas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.entity.ClientesEntity;
import com.diplomado.ventas.repository.IClientesRepository;

@Service
public class ClientesDal {
	@Autowired
	private IClientesRepository clientesRepository;

	public List<ClientesEntity> findAll() {
		return this.clientesRepository.findAll();
	}

	public ClientesEntity findById(long id) {
		return this.clientesRepository.findById(id).get();
	}

	public ClientesEntity save(ClientesEntity entity) {
		return this.clientesRepository.save(entity);
	}

	public ClientesEntity update(ClientesEntity entity)  {
		/*if(!this.clientesRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.clientesRepository.findById(entity.getId())
				.map( x -> {
					x.setNombre(entity.getNombre());
										
					return this.clientesRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.clientesRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.clientesRepository.deleteById(id);
	}
}




