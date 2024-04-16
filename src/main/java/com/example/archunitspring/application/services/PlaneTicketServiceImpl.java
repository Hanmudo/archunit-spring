package com.example.archunitspring.application.services;

import com.example.archunitspring.application.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier(value = "PlaneTicketService")
@Service
public class PlaneTicketServiceImpl implements TicketService {
    @Override
    public int getTotalTicketCount() {
        return 10;
    }

    @Override
    public void setTotalTicketCount(final int ticketCount) {

    }
}
