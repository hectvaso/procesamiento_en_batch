package com.vanegas.job.sheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FobScheduling {

	@Scheduled(cron="*/20 * * * * *")
	public void programador() {
		
		long now = System.currentTimeMillis()/ 1000;
		
		System.out.print("\n"+"inicio la ejecución de la tarea : " + now);
		
	}
}
