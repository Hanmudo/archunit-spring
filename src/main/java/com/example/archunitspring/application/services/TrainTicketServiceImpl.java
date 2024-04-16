package com.example.archunitspring.application.services;

import com.example.archunitspring.application.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier(value = "TrainTicketService")
@Service
public class TrainTicketServiceImpl implements TicketService {
    @Override
    public int getTotalTicketCount() {
        return 50;
    }

    @Override
    public void setTotalTicketCount(final int ticketCount) {

    }
}
