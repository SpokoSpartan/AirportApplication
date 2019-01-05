package com.project.application.airportapplicationproject.utils;

import com.project.application.airportapplicationproject.DTOs.Email;
import com.project.application.airportapplicationproject.entities.Ticket;

public class EmailToClientTemplate {

    public static Email getEmail(Ticket ticket) {
        Email email = new Email();
        String message = "Gratulacje! Właśnie zakupiłeś bilet z " + ticket.getCourse().getStartAirport().getCity() +
                " do " + ticket.getCourse().getEndAirport().getCity() + ". Data odlotu to " +
                ticket.getCourse().getDepartureDate() + ". Przypominamy o konieczności opłacenia " +
                "biletu w czasie 8 godzin. W przeciwnym przypadku bilet zostanie unieważniony! " +
                "Pozdrawiamy. AirportServices!!.";
        email.setMessageContext(message);
        email.setSubject("Gratulacje zakupu biletu.");
        return email;
    }
}
