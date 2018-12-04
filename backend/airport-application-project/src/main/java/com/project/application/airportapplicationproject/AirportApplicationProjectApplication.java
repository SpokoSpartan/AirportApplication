package com.project.application.airportapplicationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirportApplicationProjectApplication {

	public static void main(String[] args) {	
		SpringApplication.run(AirportApplicationProjectApplication.class, args);
		/*
		try {
			Thread.sleep(5000);
			EmailService esi = new EmailService();
			String text = "";
			text += "Witamy! ";
			text += "Właśnie przed chwila zakupiłeś bezpowrotny bilet bez gier, a już w szczególności doty! ";
			text += "Od tego momentu twoje postrzeganie świata zmieni się diametralnie! ";
			text += "Wyślij PS w wiadomości powrotnej i zdaj sobie sprawę, że tylko konsolowcy moga nazywać się graczami! ";
			text += "Wiadomość wysłana automatycznie. ";
			text += "Proszę na nia nie odpowiadać xD ";
			esi.sendSimpleMessage("wojtekspoton@gmail.com", "Informacja o zakupionym bilecie!", text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}	
}
