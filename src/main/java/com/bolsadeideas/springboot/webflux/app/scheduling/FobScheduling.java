package com.bolsadeideas.springboot.webflux.app.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;
import com.bolsadeideas.springboot.webflux.app.models.services.ProductoServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FobScheduling {
	
	@Autowired
	private ProductoServiceImpl service;
	
	Logger logger = LoggerFactory.getLogger(FobScheduling.class);

	@Scheduled(cron="*/20 * * * * *")
	public void programador() {
		
		long now = System.currentTimeMillis()/ 1000;
		
		
		
		Flux<Producto> result = service.findAll();
		
		result.subscribe(e -> logger.info("elemento {} " ,e.getNombre().toString()));
		
		
		
	
	}
	
}
