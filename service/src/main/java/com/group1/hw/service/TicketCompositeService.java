package com.group1.hw.service;

import com.group1.hw.dto.TicketDTO;

import java.util.List;

public interface TicketCompositeService {

    List<TicketDTO> getMyTickets(Long customerId);

}
