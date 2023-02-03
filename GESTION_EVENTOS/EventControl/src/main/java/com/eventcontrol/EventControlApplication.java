package com.eventcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eventcontrol.entity.AsistenteEntity;
import com.eventcontrol.entity.EventoEntity;
import com.eventcontrol.entity.SalonEntity;
import com.eventcontrol.repository.IAsistenteRepository;
import com.eventcontrol.repository.IEventoRepository;
import com.eventcontrol.repository.ISalonRepository;

@SpringBootApplication
@ComponentScan
@EntityScan(basePackages = {"com.otro.entities",
		"com.eventcontrol.entity",
		"com.audit.entities",
		"com.loggeto.login.entities"})
public class EventControlApplication implements CommandLineRunner {

	@Autowired
	private IEventoRepository eventRepository;
	@Autowired
	private IAsistenteRepository asistenteRepository;
	
	@Autowired
	private ISalonRepository salonRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(EventControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//initDb();
		/*var a = this.salonRepository.findById(1L).get();
		//var a = this.eventRepository.findById(1L).get(); 
		System.out.println(a.getNombre());		
		for (EventoEntity evt: a.getEventos()) {
			System.out.println(evt.getNombre());
		}*/
	}


	public void initDb() { 
		var salon = SalonEntity.builder().capacidad(5).descripcion("Es bonito").nombre("El salon 1").build();
		salon = this.salonRepository.save(salon);
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
		evento.setSalon(salon);
		evento = this.eventRepository.save(evento);
		
		//evento = this.eventRepository.findById(evento.getId()).get();
		
		evento.getAsistentes().add(asistente);
		evento.getAsistentes().add(asistente2);
		evento.getAsistentes().add(asistente3);

		this.eventRepository.save(evento);

		this.eventRepository.flush();
	}
}
