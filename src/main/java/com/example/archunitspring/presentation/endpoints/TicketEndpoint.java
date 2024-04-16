package com.example.archunitspring.presentation.endpoints;

import com.example.archunitspring.application.interfaces.TicketService;
import com.example.archunitspring.application.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketEndpoint {

    private TicketService planeTicketService;
    private TicketService trainTicketService;

    @Autowired
    public TicketEndpoint(@Qualifier("PlaneTicketService") final TicketService planeTicketService,
                          @Qualifier("TrainTicketService") final TicketService trainTicketService) {
        this.planeTicketService = planeTicketService;
        this.trainTicketService = trainTicketService;
    }

    @GetMapping("/tickets/plane")
    public Ticket getPlaneTicketCount() {
        return new Ticket(planeTicketService.getTotalTicketCount(), 4000, true);
    }
    @GetMapping("/tickets/train")
    public Ticket getTrainTicketCount() {
        return new Ticket(trainTicketService.getTotalTicketCount(), 500, false);
    }

}
