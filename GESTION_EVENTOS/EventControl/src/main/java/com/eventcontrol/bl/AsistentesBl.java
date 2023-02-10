package com.eventcontrol.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcontrol.dtos.AsistentesDto;
import com.eventcontrol.dtos.AsistentesMinDto;
import com.eventcontrol.repository.IAsistenteRepository;

@Service
public class AsistentesBl {

	
	@Autowired
	private IAsistenteRepository asistentesRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	public List<AsistentesDto> findAll(){
		var result = asistentesRepository.findAll();
		return mapper.map(result, new TypeToken<List<AsistentesDto>>() {
		}.getType());
	}
	
	public AsistentesMinDto findMinById(long id) {
		var result = this.asistentesRepository.findAsistentesMinById(id).get();
		return result;
	}
	public List<AsistentesMinDto> findAllMin() {
		return this.asistentesRepository.findAllAsistentesMin();		
	}
}
