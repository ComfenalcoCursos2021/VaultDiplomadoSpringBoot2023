package com.eventcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventcontrol.entity.AsistenteEntity;
import com.eventcontrol.entity.EventoEntity;
import com.eventcontrol.repository.IAsistenteRepository;
import com.eventcontrol.repository.IEventoRepository;

@SpringBootApplication
public class EventControlApplication implements CommandLineRunner {

	@Autowired
	private IEventoRepository eventRepository;
	@Autowired
	private IAsistenteRepository asistenteRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(EventControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//initDb();
		//
	}


	public void initDb() { 
		
		var asistente = AsistenteEntity.builder()
				.email("correo@correo.com")
				.nombre("alv")
				.numIdentificacion("123456")
				.build();
		var asistente2 = AsistenteEntity.builder()
				.email("correo2@correo.com")
				.nombre("alv2")
				.numIdentificacion("1234562")
				.build();
		var asistente3 = AsistenteEntity.builder()
				.email("correo3@correo.com")
				.nombre("alv3")
				.numIdentificacion("1234563")
				.build();
		
		asistente = this.asistenteRepository.save(asistente);
		asistente2 = this.asistenteRepository.save(asistente2);
		asistente3 = this.asistenteRepository.save(asistente3);

		var evento = new EventoEntity();
		evento.setNombre("Evento 1");
		
		evento = this.eventRepository.save(evento);
		
		//evento = this.eventRepository.findById(evento.getId()).get();
		
		evento.getAsistentes().add(asistente);
		evento.getAsistentes().add(asistente2);
		evento.getAsistentes().add(asistente3);

		this.eventRepository.save(evento);

		this.eventRepository.flush();
	}
}
